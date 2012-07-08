/**
 * @author ZHU JunGuan
 *2012-7-7
 *
 */
package com.wetongji;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

/**
 * @author ZHU JunGuan
 *2012-7-7
 */
public class ActivityUserProfile extends SherlockActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        setContentView(R.layout.app_profile);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("Edit")
            .setIcon(R.drawable.ic_compose)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            finish();
            return true;
        }
        if(item.getTitle().equals("Edit")) {
            // ½øÈë±à¼­Ò³Ãæ
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    

}
