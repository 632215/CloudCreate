package com.weis.cloudcreate.view.activity;

import android.view.View;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.presenter.BasePresenter;

public class SettingActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_setting;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        setTitleText(getString(R.string.activity_setting_title), View.VISIBLE);
    }

    @Override
    protected void back() {
        super.back();
        finish();
    }
}
