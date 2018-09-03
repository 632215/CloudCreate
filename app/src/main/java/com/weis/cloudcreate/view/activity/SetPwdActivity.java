package com.weis.cloudcreate.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.weis.cloudcreate.R;

import butterknife.BindView;
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pwd);
        initView();
    }

    protected void initView() {
        setTitleText(getString(R.string.activity_set_title), View.VISIBLE);
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
