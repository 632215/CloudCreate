package com.weis.cloudcreate.view;

import android.content.Intent;

/**
 * Created by Administrator on 2018/7/31.
 */

public interface BaseView {
    void toast(int msg);

    void toast(String msg);

    void showProgress();

    void showProgress(int msg);

    void showProgress(String msg);

    void dismissProgress();

    Intent getIntent();


}
