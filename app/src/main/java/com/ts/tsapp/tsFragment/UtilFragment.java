package com.ts.tsapp.tsFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ts.tsapp.R;
import com.ts.tsapp.tsBase.BaseFragment;

/**
 * 首页工具fragment  没有使用
 */
public class UtilFragment extends BaseFragment {


    public UtilFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_util, container, false);
        return  view;

    }

}
