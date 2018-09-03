package com.weis.cloudcreate.presenter;

import com.weis.cloudcreate.view.BaseView;

/**
 * Created by Administrator on 2018/7/31.
 */

public abstract class BasePresenter<T extends BaseView> {
    protected T mView;

    public void attach(T view) {
        this.mView = view;
    }

    public void disAttach() {
        this.mView = null;
    }

    protected void toast(int msg) {
        mView.toast(msg);
    }

    protected void toast(String msg) {
        mView.toast(msg);
    }
}
