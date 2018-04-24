package com.sung.digital.common;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.sung.digital.BuildConfig;
import com.sung.digital.R;

/**
 * Created by sung on 2018/4/23.
 *
 * Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected final String TAG = this.getClass().getSimpleName();

    /***是否显示标题栏*/
    private boolean isshowstate = true;
    /***封装toast对象**/
    private static Toast toast;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isshowstate) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        //设置布局
        setContentView(initLayout());
        //初始化控件
        initView();
        //设置数据
        initData();
    }

    /**init**/
    public abstract int initLayout();

    public abstract void initView();

    public abstract void initData();

    /**set**/
    public void setState(boolean ishow) {
        isshowstate = ishow;
    }

    /**toast output**/
    public void toastLong(String message) {
        if (null == toast) {
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setText(message);
            toast.show();
        } else {
            toast.setText(message);
            toast.show();
        }
    }

    public void toastShort(String message) {
        if (null == toast) {
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setText(message);
            toast.show();
        } else {
            toast.setText(message);
            toast.show();
        }
    }

    /**log output**/
    public void logD(String msg){
        if (BuildConfig.DEBUG){
            Log.d(TAG, msg);
        }
    }

    public void logE(String msg){
        if (BuildConfig.DEBUG){
            Log.e(TAG, msg);
        }
    }

    public void logW(String msg){
        if (BuildConfig.DEBUG){
            Log.w(TAG, msg);
        }
    }

    /**ui display**/
    public void showLoaddingView(){

    }

    public void showErrorView(){

    }

    public void showEmptyView(){

    }

}
