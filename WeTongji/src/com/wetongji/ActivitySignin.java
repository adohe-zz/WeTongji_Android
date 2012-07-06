package com.wetongji;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.actionbarsherlock.app.SherlockActivity;

public class ActivitySignin extends SherlockActivity {

    private ViewFlipper viewflipper;
    private Button btn_back, btn_next;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_signin);
        
        setTitle(getResources().getString(R.string.register_new_account_step1));
        
        initWidget();
    }
    
    private void initWidget() {
        viewflipper = (ViewFlipper) findViewById(R.id.widget_rg_viewflipper);
        
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(btnOnClickListener);
        btn_next = (Button) findViewById(R.id.btn_ok);
        btn_next.setOnClickListener(btnOnClickListener);
        
        
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
            switch(view.getId()) {
            case R.id.btn_back:
                
                if(viewflipper.indexOfChild(viewflipper.getCurrentView()) == 1) {
                    // 上一步
                    viewflipper.showPrevious(); 
                    ActivitySignin.this.setTitle(R.string.register_new_account_step1);

                }
                else if(viewflipper.indexOfChild(viewflipper.getCurrentView()) == 2) {
                    viewflipper.showPrevious();
                    ActivitySignin.this.setTitle(R.string.register_new_account_step2);

                }
                else {
                    finish();
                }
                break;
            case R.id.btn_ok:
                if(viewflipper.indexOfChild(viewflipper.getCurrentView()) == 1) {
                    // 下一步
                    viewflipper.showNext();
                    ActivitySignin.this.setTitle(R.string.register_new_account_step3);

                }
                else if(viewflipper.indexOfChild(viewflipper.getCurrentView()) == 0) {
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
                else {
                    // 注册
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
    
   

}
