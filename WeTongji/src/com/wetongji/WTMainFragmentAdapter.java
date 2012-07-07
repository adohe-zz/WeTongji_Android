package com.wetongji;

import com.wetongji.R.string;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter ;

public class WTMainFragmentAdapter extends FragmentPagerAdapter {
    // Ò³Êý
    static final int NUM_PAGES = 3;
    
    // Î»ÖÃ
    static final int POS_PERSONAL = 0;
    static final int POS_DASHBORD = 1;
    static final int POS_SETTING = 2;
    
    Resources resources;
    
    public WTMainFragmentAdapter(Resources resources, FragmentManager fm) {
        super(fm);   
        this.resources = resources;
    }

    @Override
    public Fragment getItem(int position) {
        // TODO Auto-generated method stub
        
        switch(position) {
        case POS_PERSONAL:
            return WTSheduleFragment.newInstance(R.layout.lay1);
        case POS_DASHBORD:
            return WTSheduleFragment.newInstance(R.layout.lay2);
            //return WTDashboardFragment.newInstance(R.layout.app_square_fragment);
        case POS_SETTING:
            return WTSheduleFragment.newInstance(R.layout.lay3);
        default:
            return WTSheduleFragment.newInstance(R.layout.lay2);
        } 
        
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return NUM_PAGES;
    }
    
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
        case 0:
            return resources.getString(string.page_alert);
        case 1:
            return resources.getString(string.page_dashboard);
        case 2:
            return resources.getString(string.page_setting);
        default:
            return null;
        }
    }

    
}
