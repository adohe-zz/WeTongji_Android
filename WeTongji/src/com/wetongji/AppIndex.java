package com.wetongji;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class AppIndex extends Activity implements OnClickListener{
    
    
    private ImageButton btn_login, btn_register;
    
    private LinearLayout  welcomeLayout;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_welcome_view);
        
        btn_login = (ImageButton) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        btn_register = (ImageButton) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
        
        welcomeLayout = (LinearLayout) findViewById(R.id.welcome_layout_welcome);
        
        
        checkExitsAccounts();
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId()) {
        case R.id.btn_login:
            Intent intent = 
                new Intent(getApplicationContext(), ActivityLogin.class);
            startActivity(intent);
            finish();
            break;
        case R.id.btn_register:
            Intent intent2 = 
                new Intent(getApplicationContext(), ActivitySignin.class);
            startActivity(intent2);
            finish();
            break;
        }
    }
    
    private void checkExitsAccounts() {
        SharedPreferences sp = 
                AppIndex.this.getSharedPreferences("SettingInfo", MODE_WORLD_READABLE);
        
        if(!sp.contains("Session")) 
        {
            welcomeLayout.setVisibility(View.VISIBLE);
        }
        else 
        {
            Intent intent = new Intent(AppIndex.this, ActivityMainViewpager.class);
            startActivity(intent);
            finish();
        }
       
    }
    
    
}