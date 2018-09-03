package com.weis.cloudcreate.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.weis.cloudcreate.view.activity.BaseActivity;

public class ActivityCallBack implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (activity instanceof BaseActivity) {
            PresenterInjector.inject((BaseActivity) activity);
        }
        if (activity instanceof FragmentActivity) {
            AcitivityUtils.addActivity((FragmentActivity) activity);
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        if (activity instanceof FragmentActivity) {
            AcitivityUtils.finishActivity((FragmentActivity) activity);
        }
    }
}
