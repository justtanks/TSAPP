package com.ts.tsapp.tsFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ts.tsapp.R;
import com.ts.tsapp.tsBase.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServicesFragment extends BaseFragment{


    public ServicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_services, container, false);
        return view;
    }

}
