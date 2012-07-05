package com.wetongji;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class AppIndex extends Activity implements OnClickListener{
    
    
    private ImageButton btn_login;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_welcome_view);
        
        btn_login = (ImageButton) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId()) {
        case R.id.btn_login:
            Intent intent = 
                new Intent(getApplicationContext(), ActivityLogin.class);
            startActivity(intent);
            break;
        }
    }
    
    
}