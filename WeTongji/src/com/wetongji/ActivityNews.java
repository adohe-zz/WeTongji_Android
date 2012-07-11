package com.wetongji;

import com.actionbarsherlock.app.SherlockActivity;
import android.os.Bundle;

public class ActivityNews extends SherlockActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_news);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
