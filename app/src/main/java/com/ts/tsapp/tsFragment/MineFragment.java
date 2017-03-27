package com.ts.tsapp.tsFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ts.tsapp.R;
import com.ts.tsapp.tsBase.BaseFragment;
/*
   我的 界面
 */

public class MineFragment extends BaseFragment {

    public MineFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {;
        View view=inflater.inflate(R.layout.fragment_mine,container,false);
        return view;

    }


}
