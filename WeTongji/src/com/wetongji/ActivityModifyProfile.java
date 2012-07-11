/**
 * @author ZHU JunGuan
 *2012-7-11
 *
 */
package com.wetongji;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.wetongji.data.DbHelper;
import com.wetongji.data.User;

/**
 * @author ZHU JunGuan
 *2012-7-11
 */
public class ActivityModifyProfile extends SherlockActivity {
    
    private DbHelper dbHelper;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.modify_personal_info);
        setContentView(R.layout.app_modify_profile);
        
        readCurrentUser();
        setTextView();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("Save")
            .setIcon(android.R.drawable.ic_menu_save)
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
        if(item.getTitle().equals("Save")) {
            // ½øÈë±à¼­Ò³Ãæ
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    
  
    
    private void readCurrentUser() {
        dbHelper = OpenHelperManager.getHelper(getApplicationContext(), DbHelper.class);
        RuntimeExceptionDao<User, String> userDao = dbHelper.getUserDao();
        
        SharedPreferences sp = 
                getApplicationContext().getSharedPreferences("SettingInfo", MODE_WORLD_READABLE);
        
        mUser = userDao.queryForId(sp.getString("CurrentSchoolNumber", ""));
    }
    
    private void setTextView() {
        if(mUser == null) {
            return;
        }
        
        EditText editText = (EditText)findViewById(R.id.et_profile_telephone);
        editText.setText(mUser.getPhone());
        editText.setOnClickListener(onEditTextClickListener);
        editText = (EditText)findViewById(R.id.et_profile_email);
        editText.setText(mUser.getEmail());
        editText.setOnClickListener(onEditTextClickListener);
        editText = (EditText)findViewById(R.id.et_profile_qq);
        editText.setText(mUser.getQQ());
        editText.setOnClickListener(onEditTextClickListener);
        editText = (EditText)findViewById(R.id.et_profile_sina_weibo);
        editText.setText(mUser.getSinaWeibo());
        editText.setOnClickListener(onEditTextClickListener);
        
    }
    
    private OnClickListener onEditTextClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            ((EditText)v).selectAll();
            ((EditText)v).setSelection(((EditText)v).getText().length() - 1);
        }
        
    };

}
