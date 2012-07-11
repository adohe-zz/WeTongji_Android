/**
 * @author ZHU JunGuan
 *2012-7-7
 *
 */
package com.wetongji;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
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
 *2012-7-7
 */
public class ActivityUserProfile extends SherlockActivity {
    
    private User mUser;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.personal_info);
        setContentView(R.layout.app_profile);
        
        readCurrentUser();
        setTextView();
        
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
            // 进入编辑页面
            startActivity(new Intent(this, ActivityModifyProfile.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    
    
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        readCurrentUser();
        setTextView();
    }

    
    
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if(dbHelper!=null){
            OpenHelperManager.releaseHelper();
            dbHelper=null;
        }
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
        
        TextView textView = (TextView)findViewById(R.id.tv_profile_name);
        textView.setText(mUser.getName());
        textView = (TextView)findViewById(R.id.tv_profile_gender);
        textView.setText(mUser.getGender());
        textView = (TextView)findViewById(R.id.tv_profile_student_num);
        textView.setText(mUser.getNO());
        textView = (TextView)findViewById(R.id.tv_profile_entrance_year);
        textView.setText(mUser.getYear());
        textView = (TextView)findViewById(R.id.tv_profile_plan);
        textView.setText(mUser.getPlan());
        textView = (TextView)findViewById(R.id.tv_profile_school);
        textView.setText(mUser.getDepartment());
        textView = (TextView)findViewById(R.id.tv_profile_major);
        textView.setText(mUser.getMajor());
        textView = (TextView)findViewById(R.id.tv_profile_telephone);
        textView.setText(mUser.getPhone());
        textView = (TextView)findViewById(R.id.tv_profile_email);
        textView.setText(mUser.getEmail());
        textView = (TextView)findViewById(R.id.tv_profile_qq);
        textView.setText(mUser.getQQ());
        textView = (TextView)findViewById(R.id.tv_profile_sina_weibo);
        textView.setText(mUser.getSinaWeibo());
        
        // 设置生日
        String strBirthday = mUser.getBirthday().substring(0, 10);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = format1.parse(strBirthday);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日");
        textView = (TextView)findViewById(R.id.tv_profile_birthday);
        textView.setText(format2.format(date));
    }
    
    

}
