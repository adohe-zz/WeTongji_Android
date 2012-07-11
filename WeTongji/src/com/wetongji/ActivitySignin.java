package com.wetongji;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.actionbarsherlock.app.SherlockActivity;
import com.wetongji.net.WTClient;

public class ActivitySignin extends SherlockActivity {

    private ViewFlipper viewflipper;
    private Button btn_back, btn_next;
    private EditText rg_name, rg_number, rg_pwd, rg_pwd_con;
    
    private CustomProgressDialog progressDialog = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_signin);
        
        setTitle(getResources().getString(R.string.register_new_account_step1));
        
        initWidget();
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            startActivity(new Intent(this, AppIndex.class));
            return false;
        }
        return super.onKeyDown(keyCode, event);
        
    }
    
    private void initWidget() {
        viewflipper = (ViewFlipper) findViewById(R.id.widget_rg_viewflipper);
        
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(btnOnClickListener);
        btn_next = (Button) findViewById(R.id.btn_ok);
        btn_next.setOnClickListener(btnOnClickListener);
        
        rg_name = (EditText)findViewById(R.id.rg_et_name);
        rg_number = (EditText)findViewById(R.id.rg_et_number);
        rg_pwd = (EditText)findViewById(R.id.rg_et_pwd);
        rg_pwd_con = (EditText)findViewById(R.id.rg_et_pwd_confim);
        
        // 中文标题设置成粗体
        TextView tv_user_protocol_title = (TextView) findViewById(R.id.tv_user_protocol_title);        
        TextPaint tp = tv_user_protocol_title.getPaint();
        tp.setFakeBoldText(true);
        
        TextView tv_register_email_title = (TextView) findViewById(R.id.tv_register_email_title);
        TextPaint tp2 = tv_register_email_title.getPaint();
        tp2.setFakeBoldText(true);
        
        // 注册链接设置点击监听
        TextView tv_register_email_link = (TextView) findViewById(R.id.tv_register_email_link);
        tv_register_email_link.setOnClickListener(btnOnClickListener);
        
    }
    
    private OnClickListener btnOnClickListener = new OnClickListener() {

        @Override
        public void onClick(View view) {
            // TODO Auto-generated method stub
            switch(view.getId()) 
            {
            case R.id.btn_back:
                
                if(viewflipper.indexOfChild(viewflipper.getCurrentView()) == 1) 
                {
                    // 上一步
                    viewflipper.showPrevious(); 
                    ActivitySignin.this.setTitle(R.string.register_new_account_step1);

                }
                else if(viewflipper.indexOfChild(viewflipper.getCurrentView()) == 2) 
                {
                    viewflipper.showPrevious();
                    ActivitySignin.this.setTitle(R.string.register_new_account_step2);
                    btn_next.setText(R.string.next);

                }
                else {
                    Intent intent = new Intent(ActivitySignin.this, AppIndex.class);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.btn_ok:
                if(viewflipper.indexOfChild(viewflipper.getCurrentView()) == 1) 
                {
                    // 下一步
                    viewflipper.showNext();
                    ActivitySignin.this.setTitle(R.string.register_new_account_step3);
                    btn_next.setText(R.string.zhuce);

                }
                else if(viewflipper.indexOfChild(viewflipper.getCurrentView()) == 0) 
                {
                    // 确认同意用户协议
                    
                    new AlertDialog.Builder(ActivitySignin.this)
                    .setTitle(R.string.ensure_agree_user_protocol)
                    .setMessage(R.string.ensure_user_protocol_dialog_message)
                    .setPositiveButton(R.string.ensure,
                            new DialogInterface.OnClickListener() {
                                
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    viewflipper.showNext();
                                    ActivitySignin.this.setTitle(R.string.register_new_account_step2);
                                }
                            })
                    .setNegativeButton(R.string.cancle, null).show();
                }
                else 
                {
                    // 注册
                	if(ActivitySignin.this.isParameterValid())
                	{
                		SignInTask task = new SignInTask();
                		task.execute();
                	}
                }
                break;
            case R.id.tv_register_email_link:
                
                // 浏览器注册邮箱
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mail.tongji.edu.cn"));
                //it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                startActivity(it);
                break;
            }
        }
    };
    
    public boolean isParameterValid()
    {
    	boolean result = true;
    	
    	if(rg_name.getText().toString().equals(""))
    	{
    		Toast.makeText(getApplicationContext(), R.string.input_name_hint, 
    				Toast.LENGTH_SHORT).show();
    		result = false;
    	}else if(rg_number.getText().toString().equals(""))
    	{
    		Toast.makeText(getApplicationContext(), R.string.input_number_hint, 
    				Toast.LENGTH_SHORT).show();
    		result = false;
    	}else if(rg_pwd.getText().toString().equals(""))
    	{
    		Toast.makeText(getApplicationContext(), R.string.input_password_hint, 
    				Toast.LENGTH_SHORT).show();
    		result = false;
    	}else if(this.isSuitableForPassword(rg_pwd.getText().toString()))
    	{
    		Toast.makeText(getApplicationContext(), R.string.input_password_pattern, 
    				Toast.LENGTH_SHORT).show();
    		result = false;
    	}else if(rg_pwd.getText().toString().length() < 6)
    	{
    		Toast.makeText(getApplicationContext(), R.string.input_password_hint_least, 
    				Toast.LENGTH_SHORT).show();
    		result = false;
    	}else if(rg_pwd_con.getText().toString().equals(""))
    	{
    		Toast.makeText(getApplicationContext(), R.string.repeat_password_hint, 
    				Toast.LENGTH_SHORT).show();
    		result = false;
    	}else if(!rg_pwd_con.getText().toString().equals(rg_pwd.getText().toString()))
    	{
    		Toast.makeText(getApplicationContext(), R.string.repeat_password_hint_again, 
    				Toast.LENGTH_SHORT).show();
    		result = false;
    	}
    	
    	return result;
    }
   
    public boolean isSuitableForPassword(String password)
    {
    	boolean result = false;
    	
    	String strRegex = "^/w+$";
    	Pattern p = Pattern.compile(strRegex);
    	
    	Matcher m = p.matcher(password);
    	
    	if(m.matches())
    		result = true;
    	
    	return result;
    }

    private void startProgressDialog()
    {
        
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
    
    //添加注册异步任务
    public class SignInTask extends AsyncTask<Integer, String , Integer>
    {
    	private WTClient wTClient;
		@Override
		protected Integer doInBackground(Integer... params) 
		{
			// TODO Auto-generated method stub
			wTClient = WTClient.getInstance();
			
			try 
			{
				wTClient.activeUser(rg_number.getText().toString(), 
						rg_name.getText().toString(), 
						rg_pwd.getText().toString());
				
				if(!wTClient.isHasError())
				{
        			return 0;
				}else
				{
					return wTClient.getResponseStatusCode();
				}
				
			} catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 1;
			}
		}
		@Override
        protected void onCancelled() 
		{
			stopProgressDialog();
		}
		@Override
        protected void onPostExecute(Integer result) 
		{
			if(result == 0)
			{	
			    new AlertDialog.Builder(ActivitySignin.this)
                .setTitle(R.string.register_success_title)
                .setMessage(R.string.register_success_message)
                .setPositiveButton(R.string.ensure,
                        new DialogInterface.OnClickListener() {
                            
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                ActivitySignin.this
                                    .startActivity(new Intent(ActivitySignin.this,
                                            ActivityLogin.class));
                                ActivitySignin.this.finish();
                            }
                        }).show();
			}else
			{
//				Toast.makeText(getApplicationContext(), this.wTClient.getErrorDesc(), 
//                		Toast.LENGTH_SHORT).show();
				Toast.makeText(getApplicationContext(), "尼玛" + result, 
                        Toast.LENGTH_SHORT).show();
			}
			stopProgressDialog();
		}
		@Override
	    protected void onPreExecute() 
		{
			 startProgressDialog();
		}
    }
}
