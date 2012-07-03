package com.wetongji;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter ;

public class WTMainFragmentAdapter extends FragmentPagerAdapter {
    
    static final int NUM_PAGES = 3;
    static final int POS_PERSONAL = 0;
    static final int POS_DASHBORD = 1;
    static final int POS_SETTING = 2;
    
    public WTMainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // TODO Auto-generated method stub
        
        switch(position) {
        case POS_PERSONAL:
            return WTDashbordFragment.newInstance(R.layout.lay1);
        case POS_DASHBORD:
            return WTDashbordFragment.newInstance(R.layout.lay2);
        case POS_SETTING:
            return WTDashbordFragment.newInstance(R.layout.lay3);
        default:
            return WTDashbordFragment.newInstance(R.layout.lay1);
        } 
        
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return NUM_PAGES;
    }

    
}
