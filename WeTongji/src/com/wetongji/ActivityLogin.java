package com.wetongji;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.wetongji.net.WTClient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends SherlockActivity {
    
    private Button btn_login, btn_cancle;
    private EditText et_username, et_password;

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
                break;
            case R.id.btn_ok:
                
                
                WTClient wTClient;
                // µÇÂ¼
                try {
                    wTClient = WTClient.getInstance();
                    wTClient.login(et_username.getText().toString(),
                            et_password.getText().toString());
                    
                    if(!wTClient.isHasError()) {
                        Intent intent = 
                                new Intent(getApplicationContext(), ActivityMainViewpager.class);
                    startActivity(intent);
                    
                    Toast.makeText(getApplicationContext(), R.string.login, Toast.LENGTH_SHORT)
                    .show();
                        break;
                    }
                    
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
                
                
               
            }
        }
        
    };

}
