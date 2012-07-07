package com.wetongji;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.wetongji.net.WTClient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends SherlockActivity {
    
    private Button btn_login, btn_cancle;
    private EditText et_username, et_password;
    
    private CustomProgressDialog progressDialog = null;


    @Override
    protected void onCreate(Bundle arg0) {
        // TODO Auto-generated method stub
        super.onCreate(arg0);
        
        setContentView(R.layout.app_login);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getResources().getString(R.string.login));
        
        initWidget();
        
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            finish();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    
    private void initWidget() {
        btn_login = (Button) findViewById(R.id.btn_ok);
        btn_login.setOnClickListener(btnClickListener);
        btn_cancle = (Button) findViewById(R.id.btn_back);
        btn_cancle.setOnClickListener(btnClickListener);
        
        et_username = (EditText) findViewById(R.id.login_et_username);
        et_password = (EditText) findViewById(R.id.login_et_pwd);
        
    }
    
    private OnClickListener btnClickListener = new OnClickListener() {

        @Override
        public void onClick(View view) {
            // TODO Auto-generated method stub
            switch(view.getId()) {
            case R.id.btn_back:
                finish();
                startActivity(new Intent(ActivityLogin.this, AppIndex.class));
                break;
            case R.id.btn_ok:
                LoginTask task = new LoginTask();
                task.execute();
                
                break;   
                               
            }
        }
        
    };
    
    
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            startActivity(new Intent(ActivityLogin.this, AppIndex.class));
            return false;
        }
        return super.onKeyDown(keyCode, event);
        
    }

    private void startProgressDialog(){
        
        if (progressDialog == null){
    
            progressDialog = CustomProgressDialog.createDialog(this);
   
            progressDialog.setMessage("���ڼ�����...");
   
        }
              
        progressDialog.show();
   
    }
    
    private void stopProgressDialog(){
        if (progressDialog != null){
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
    
    public class LoginTask extends AsyncTask<Integer, String, Integer> {

        /* (non-Javadoc)
         * @see android.os.AsyncTask#doInBackground(Params[])
         */
        @Override
        protected Integer doInBackground(Integer... arg0) {
            // TODO Auto-generated method stub
            
            WTClient wTClient;
            // ��¼
            try {
                wTClient = WTClient.getInstance();
                wTClient.login(et_username.getText().toString(),
                        et_password.getText().toString());
                
                if(!wTClient.isHasError()) {
                    
                    Intent intent = 
                            new Intent(getApplicationContext(), ActivityMainViewpager.class);
                    startActivity(intent);
                    finish();
                    
                    return 0;
                }
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return 1;
            }
            return 1;
        }

        @Override
        protected void onCancelled() {
            // TODO Auto-generated method stub
            stopProgressDialog();
        }

        @Override
        protected void onPostExecute(Integer result) {
            // TODO Auto-generated method stub
            if(result == 0) {
                writePreference("exitsAccount", true);
                
                Toast.makeText(getApplicationContext(), R.string.login, Toast.LENGTH_SHORT)
                    .show();
            }
            stopProgressDialog();
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            startProgressDialog();
        }                      
    }

    private void writePreference(String key, Boolean value) {
        SharedPreferences.Editor editor = 
                ActivityLogin.this.getSharedPreferences("SettingInfo", MODE_WORLD_WRITEABLE)
                .edit();
        
        editor.putBoolean(key, value);
        editor.commit();
    }
    
}
