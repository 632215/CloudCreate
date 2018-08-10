package com.weis.cloudcreate.presenter;

import android.view.View;

/**
 * Created by Administrator on 2018/7/31.
 */

public abstract class BasePresenter<T> {
    private T mView;

    public void attach(T view) {
        this.mView = (T) view;
    }

    public void disAttach() {
        this.mView = null;
    }
}
