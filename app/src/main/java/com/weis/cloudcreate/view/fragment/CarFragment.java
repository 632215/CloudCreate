package com.weis.cloudcreate.view.fragment;

import android.os.Bundle;
import android.view.View;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.presenter.BasePresenter;

/**
 * Created by Administrator on 2018/8/3.
 */

public class CarFragment extends BaseFragment{
    @Override
    protected int getContentView() {
        return R.layout.fragment_car;
    }

    @Override
    BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }
}
