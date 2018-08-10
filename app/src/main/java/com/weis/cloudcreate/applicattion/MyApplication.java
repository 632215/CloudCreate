package com.weis.cloudcreate.applicattion;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.support.multidex.MultiDex;

import com.lody.turbodex.TurboDex;
import com.weis.cloudcreate.utils.LogUtils;
import com.weis.cloudcreate.utils.Utils;

import java.lang.reflect.Field;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/31.
 */

public class MyApplication extends Application {
    private MyApplication intance;
    private Typeface typeface;

    public MyApplication getIntance() {
        return intance;
    }

    public void setIntance(MyApplication intance) {
        this.intance = intance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setIntance(this);
        Utils.init(this);
        //分包处理
        ButterKnife.setDebug(true);
        LogUtils.Builder builder = new LogUtils.Builder();
        builder.setGlobalTag("32s");
    }

    @Override
    protected void attachBaseContext(Context base) {
        TurboDex.enableTurboDex();
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
