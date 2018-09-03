package com.weis.cloudcreate.utils;

import com.weis.cloudcreate.anno.Presentor;
import com.weis.cloudcreate.presenter.BasePresenter;
import com.weis.cloudcreate.view.activity.BaseActivity;
import com.weis.cloudcreate.view.fragment.BaseFragment;

import java.lang.reflect.Field;

public class PresenterInjector {
    public static void inject(BaseActivity activity) {
        Class<? extends BaseActivity> activityClass = activity.getClass();
        Field[] declaredFields = activityClass.getDeclaredFields();
        if (declaredFields != null) {
            for (Field field : declaredFields) {
                if (field.getAnnotation(Presentor.class) != null) {
                    field.setAccessible(true);
                    initPresenter(activity, field);
                }
            }
        }
    }

    private static void initPresenter(BaseActivity activity, Field field) {
        Class<? extends BasePresenter> presenterClass = field.getType().asSubclass(BasePresenter.class);
        try {
            BasePresenter presenter = presenterClass.newInstance();
            field.set(activity, presenter);
            presenter.attach(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void inject(BaseFragment fragment) {
        Class<? extends BaseFragment> fragmentClass = fragment.getClass();
        Field[] declaredFields = fragmentClass.getDeclaredFields();
        if (declaredFields != null) {
            for (Field field : declaredFields) {
                if (field.getAnnotation(Presentor.class) != null) {
                    field.setAccessible(true);
                    initPresenter(fragment, field);
                }
            }
        }
    }
    private static void initPresenter(BaseFragment fragment, Field field) {
        Class<? extends BasePresenter> presenterClass = field.getType().asSubclass(BasePresenter.class);
        try {
            BasePresenter presenter = presenterClass.newInstance();
            field.set(fragment, presenter);
            presenter.attach(fragment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
