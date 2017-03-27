package com.ts.tsapp.tsBase;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2016/12/28.
 * activity基类
 */
import org.xutils.x;

public abstract class BaseActivity extends AppCompatActivity {

    public Context context;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        context=getApplicationContext();
        EventBus.getDefault().register(this);
        x.view().inject(this);


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

      public void loge(String logMsg){
          Log.e("log",logMsg);

    }
    public void loge(String key,String logMsg){
        Log.e(key,logMsg);
    }

    public void toast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
    public void longToast(String msg){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }


    //判断是否能够连接到网络
    public boolean isConnect() {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        Toast.makeText(context, "请检查你的网络", Toast.LENGTH_SHORT).show();
        return false;
    }
}
