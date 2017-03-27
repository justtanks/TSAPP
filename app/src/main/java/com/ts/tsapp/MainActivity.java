package com.ts.tsapp;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.ts.tsapp.tsActivity.UtilsActivity;
import com.ts.tsapp.tsBase.BaseActivity;
import com.ts.tsapp.tsFragment.HomeFragment;
import com.ts.tsapp.tsFragment.MineFragment;
import com.ts.tsapp.tsFragment.UtilFragment;
import com.ts.tsapp.utils.ShareUtils;

import org.xutils.view.annotation.ViewInject;

/*
   主界面activity
 */

public class MainActivity extends BaseActivity {

    //测试首页
    private long currentTime;
    private static FragmentTabHost mTabHost;
    private Class mFragmentArray[] = {HomeFragment.class,  UtilFragment.class,
            MineFragment.class};
    private int mImageArray[] = {R.drawable.tab_home, R.drawable.tab_order ,R.drawable.tab_mine};
    private String textArray[] = {"首页", "工具", "我的"};
    private LayoutInflater mInflater;
    private boolean isRigs=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView(){

        mTabHost= (FragmentTabHost)findViewById(R.id.home_tab);
        mInflater=LayoutInflater.from(this);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.home_content);
        mTabHost.getTabWidget().setDividerDrawable(R.color.white);//去掉tabhost的分割线
        int count = mFragmentArray.length;
        for (int i = 0; i < count; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(textArray[i]).setIndicator(getTabItemView(i));
                mTabHost.addTab(tabSpec, mFragmentArray[i], null);
        }
        updateTab(mTabHost);
        mTabHost.setOnTabChangedListener(tabChangeListener);
        //添加工具界面的点击事件
        currentTime=System.currentTimeMillis();
    }

    private TabHost.OnTabChangeListener tabChangeListener = new TabHost.OnTabChangeListener() {
        @Override
        public void onTabChanged(String s) {
            updateTab(mTabHost);
        }
    };
    //          更新tab键文字
    private void updateTab(FragmentTabHost mTabHost) {
        for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
            View view = mTabHost.getTabWidget().getChildAt(i);
            TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(R.id.textview);
            if (mTabHost.getCurrentTab() == i) {//选中
                tv.setTextColor(this.getResources().getColorStateList(
                        R.color.orange));

            } else {//不选中
                tv.setTextColor(this.getResources().getColorStateList(
                        R.color.colortabtext));
            }
        }
    }
    //      为tab键设置图片和文字
    private View getTabItemView(int index) {
        View view = mInflater.inflate(R.layout.tab_item_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview_1);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        imageView.setImageResource(mImageArray[index]);
        textView.setText(textArray[index]);
        return view;
    }

    @Override
    public void onBackPressed() {
        long time=System.currentTimeMillis();
        if(time-currentTime>3000){
            Toast.makeText(this, R.string.home_backpress, Toast.LENGTH_SHORT).show();
            currentTime=time;
            return;
        }
        super.onBackPressed();
    }

    //设置用户名 密码以及登录状态标示
    private  boolean getUser(){
        String userName = (String) ShareUtils.get(this,"userName","");
        String passWord= (String) ShareUtils.get(this,"passWord","");
        if(userName!=null&&userName!=""&&passWord!=null&&passWord!=""){
            return true;
        }


        return false;
    }






}
