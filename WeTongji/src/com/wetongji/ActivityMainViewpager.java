package com.wetongji;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.viewpagerindicator.TitlePageIndicator;

public class ActivityMainViewpager extends SherlockFragmentActivity {
    
    private ViewPager mPager;//页卡内容    
    private TitlePageIndicator indicator; // 
        
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
        this.setContentView(R.layout.app_main_viewpager);
                   
        setTitle("微同济");
        
        InitViewPager();
        
        
    }

    
    /**
     * 初始化ViewPager
     */
    private void InitViewPager() {
        mPager = (ViewPager) findViewById(R.id.widget_main_viewpager);
        
        mPager.setAdapter(new WTMainFragmentAdapter(getResources(), getSupportFragmentManager()));
        mPager.setCurrentItem(1);
        
        //初始化指示器
        indicator = (TitlePageIndicator) findViewById(R.id.widget_viewpager_header);
        indicator.setViewPager(mPager);

    }
    
    
    /**
     * 头标点击监听
    */
    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        public void onClick(View v) {
            mPager.setCurrentItem(index);
        }
    };            
    
    
    @Override 
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // your stuff or nothing
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // your stuff or nothing
    }
}




