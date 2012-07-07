package com.wetongji;

import com.actionbarsherlock.app.SherlockFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WTSheduleFragment extends SherlockFragment{
    static  int LAYOUT_ID;
    
    public static WTSheduleFragment newInstance(int layout_id){
        WTSheduleFragment f = new WTSheduleFragment();

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
        
        View v = inflater.inflate(LAYOUT_ID, container, false); 
        
        return v;
    }

}
