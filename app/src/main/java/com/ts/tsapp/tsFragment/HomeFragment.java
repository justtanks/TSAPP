package com.ts.tsapp.tsFragment;

import android.media.Image;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ts.tsapp.R;
import com.ts.tsapp.tsBase.BaseFragment;
import com.ts.tsapp.utils.DensityUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
/*
   首页fragments
 */

@ContentView(R.layout.fragment_home)
public class HomeFragment extends BaseFragment implements TextView.OnEditorActionListener ,View.OnClickListener{
    @ViewInject(R.id.home_search_edit)
    private EditText msearchText;
    @ViewInject(R.id.fragment_home_head)
    private ImageView mheadImg;
    @ViewInject(R.id.home_msgbt)
    private ImageView mmsgImg;
    @ViewInject(R.id.home_search_before)
    private ImageView msearchBefore;
    @ViewInject(R.id.home_img_reg)
    private ImageView  mregis;

    @ViewInject(R.id.home_img_buy)
    private ImageView mbuy;
    @ViewInject(R.id.home_world_reg)
    private ImageView mworldRig;
    @ViewInject(R.id.home_img_search)
    private ImageView msearch;
    @ViewInject(R.id.home_img_name)
    private ImageView mname;
    @ViewInject(R.id.home_img_fenlei)
    private ImageView mfenlei;
    @ViewInject(R.id.home_img_jindu)
    private ImageView mregSearch;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview();
    }

    private void initview() {
        Log.e("todp ", "转换为dp" + "30=" + DensityUtils.px2dp(getContext(), 30) + "--20=" + DensityUtils.px2dp(getContext(), 20) + "---15=" + DensityUtils.px2dp(getContext(), 15) + "-----36=" + DensityUtils.px2dp(getContext(), 36) + "--70=" + DensityUtils.px2dp(getContext(), 70));
        Log.e("todp", "转换sp34=" + DensityUtils.px2sp(getContext(), 34) + "--24=" + DensityUtils.px2sp(getContext(), 24) + "--28=" + DensityUtils.px2sp(getContext(), 28));
        msearchText.setOnEditorActionListener(this);
        mheadImg.setOnClickListener(this);
        mbuy.setOnClickListener(this);
        mfenlei.setOnClickListener(this);
        mheadImg.setOnClickListener(this);
        mmsgImg.setOnClickListener(this);
        mname.setOnClickListener(this);
        mregis.setOnClickListener(this);
        mregSearch.setOnClickListener(this);
        msearchBefore.setOnClickListener(this);
        mworldRig.setOnClickListener(this);
        msearch.setOnClickListener(this);

    }

/*
   点击搜索之后操作
 */
    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == EditorInfo.IME_ACTION_SEARCH) {
            //收起软键盘
            InputMethodManager im = (InputMethodManager)getActivity().getSystemService(getContext().INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(getActivity().getCurrentFocus().getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);


        return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_search_before:
                Toast.makeText(getContext(), "前查询", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_img_reg:
                Toast.makeText(getContext(), "注册", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_img_buy:
                Toast.makeText(getContext(), "商标购买", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_world_reg:
                Toast.makeText(getContext(), "国际注册", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_img_search:
                Toast.makeText(getContext(), "商标查询", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_img_fenlei:
                Toast.makeText(getContext(), "分类", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_img_name:
                Toast.makeText(getContext(), "命名", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_img_jindu:
                Toast.makeText(getContext(), "进度", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fragment_home_head:
                Toast.makeText(getContext(), "头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home_msgbt:
                Toast.makeText(getContext(), "头像", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;

    }
    }
}
