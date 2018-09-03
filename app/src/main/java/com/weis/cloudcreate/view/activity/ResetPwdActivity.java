package com.weis.cloudcreate.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.weis.cloudcreate.R;

import butterknife.OnClick;

/**
 * Created by Administrator on 2018/7/30.
 */

public class ResetPwdActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pwd);
        initView();
    }

    protected void initView() {
        setTitleText(getString(R.string.activity_reset_pwd_title), View.VISIBLE);
    }

    @OnClick({R.id.img_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_sure:
                startActivity(new Intent(this, SetPwdActivity.class));
                break;
        }
    }
}
