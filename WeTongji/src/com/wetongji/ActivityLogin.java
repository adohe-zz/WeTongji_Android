package com.wetongji;

import org.json.JSONObject;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.google.gson.Gson;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.wetongji.data.DbHelper;
import com.wetongji.data.User;
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

    private DbHelper dbHelper=null;
    
    private String mCurrentNO;

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
            switch(view.getId()) 
            {
            case R.id.btn_back:
                finish();
                startActivity(new Intent(ActivityLogin.this, AppIndex.class));
                break;
            case R.id.btn_ok:
            	if(ActivityLogin.this.isParameterValid())
            	{
            		LoginTask task = new LoginTask();
            		task.execute();
            	}
                break;                
            }
        }
        
    };
    
    public boolean isParameterValid()
    {
    	boolean result = true;
    	
    	if(et_username.getText().toString().equals(""))
    	{
    		Toast.makeText(getApplicationContext(), R.string.input_account_hint, 
    				Toast.LENGTH_SHORT).show();
    		result = false;
    	}else if(et_password.getText().toString().equals(""))
    	{
    		Toast.makeText(getApplicationContext(), R.string.input_password_hint, 
    				Toast.LENGTH_SHORT).show();
    		result = false;
    	}else if(et_password.getText().toString().length() < 6)
    	{
    		Toast.makeText(getApplicationContext(), R.string.input_password_hint_least, 
    				Toast.LENGTH_SHORT).show();
    		result = false;
    	}
    	return result;
    }
    
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
   
            progressDialog.setMessage("正在加载中...");
   
        }
              
        progressDialog.show();
   
    }
    
    private void stopProgressDialog(){
        if (progressDialog != null){
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
    
    public void createUser(String jsonStr) throws Exception
    {
    	JSONObject data = new JSONObject(jsonStr);
    	JSONObject userStr = data.getJSONObject("User");
    	
    	Gson gson = new Gson();
    	
    	User user = gson.fromJson(userStr.toString(), User.class);
    	
    	//写入user到数据库
    	dbHelper=OpenHelperManager.getHelper(getApplicationContext(), DbHelper.class);
    	RuntimeExceptionDao<User, String> userDao=dbHelper.getUserDao();
		userDao.createIfNotExists(user);
		
		mCurrentNO = user.getNO();
		
    }
    public class LoginTask extends AsyncTask<Integer, String, Integer> 
    {
    	private WTClient wTClient;
    	
        /* (non-Javadoc)
         * @see android.os.AsyncTask#doInBackground(Params[])
         */
        @Override
        protected Integer doInBackground(Integer... arg0) 
        {
            // TODO Auto-generated method stub
            // 登录
        	try
        	{
        		this.wTClient = WTClient.getInstance();
        		this.wTClient.login(et_username.getText().toString(), 
        				et_password.getText().toString());
        		
        		if(!this.wTClient.isHasError())
        		{
        		    ActivityLogin.this.createUser(this.wTClient.getResponseStr());
        			writePreference("CurrentSchoolNumber", 
                          ActivityLogin.this.mCurrentNO);
        			
        			Intent intent = new Intent(getApplicationContext(), ActivityMainViewpager.class);
        			startActivity(intent);
        			finish();
        			
        			return 0;
        		}else
        		{
        			return this.wTClient.getResponseStatusCode();
        		}
        	}catch(Exception e)
        	{
        		e.printStackTrace();
        		return 1;
        	}
        }

        @Override
        protected void onCancelled() 
        {
            // TODO Auto-generated method stub
            stopProgressDialog();
        }

        @Override
        protected void onPostExecute(Integer result) 
        {
            // TODO Auto-generated method stub
            if(result == 0) 
            {
                writePreference("Session", this.wTClient.getSession());
                
                
                Toast.makeText(getApplicationContext(), R.string.login_success, 
                		Toast.LENGTH_SHORT).show();
            }else 
            {
                Toast.makeText(getApplicationContext(), this.wTClient.getErrorDesc(), 
                		Toast.LENGTH_SHORT).show();
            }
            stopProgressDialog();
        }

        @Override
        protected void onPreExecute() 
        {
            // TODO Auto-generated method stub
            startProgressDialog();
        }                      
    }
    
    private void writePreference(String key, String value)
    {
    	SharedPreferences.Editor editor = ActivityLogin.this.getSharedPreferences("SettingInfo", MODE_WORLD_WRITEABLE)
    			.edit();
    	editor.putString(key, value);
    	editor.commit();
    }


	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(dbHelper!=null){
			OpenHelperManager.releaseHelper();
			dbHelper=null;
			dbHelper=null;
		}
	}
}
