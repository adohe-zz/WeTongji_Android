package com.wetongji;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WTDashbordFragment extends Fragment {

    static  int LAYOUT_ID;
    
    public static WTDashbordFragment newInstance(int layout_id){
        WTDashbordFragment f = new WTDashbordFragment();

        // Supply LAYOUT_ID input as an argument.
        Bundle args = new Bundle();
        args.putInt("layout_id", layout_id);
        f.setArguments(args);

        return f;
    }
    
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        LAYOUT_ID = getArguments() != null ? getArguments().getInt("layout_id") : R.layout.lay1;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        
        View v = inflater.inflate(R.layout.app_welcome_view, container, false);
        return v;
    }

}
