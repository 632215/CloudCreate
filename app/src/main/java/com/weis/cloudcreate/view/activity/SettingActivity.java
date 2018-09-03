package com.weis.cloudcreate.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.weis.cloudcreate.R;

public class SettingActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
    }

    protected void initView() {
        setTitleText(getString(R.string.activity_setting_title), View.VISIBLE);
    }

}
