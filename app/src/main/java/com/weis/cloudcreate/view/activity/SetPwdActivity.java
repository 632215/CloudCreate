package com.weis.cloudcreate.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.presenter.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/7/30.
 */

public class SetPwdActivity extends BaseActivity {
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.et_pwd_confirm)
    EditText etPwdConfirm;

    @Override
    protected int getContentView() {
        return R.layout.activity_set_pwd;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        setTitleText(getString(R.string.activity_set_title), View.VISIBLE);
    }

    @Override
    protected void back() {
        super.back();
        finish();
    }

    @OnClick({R.id.img_sure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_sure:
                startActivity(new Intent(this, MsgAuthActivity.class));
                break;
        }
    }
}
