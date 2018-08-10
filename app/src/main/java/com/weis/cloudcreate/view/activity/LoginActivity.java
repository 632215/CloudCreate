package com.weis.cloudcreate.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.presenter.BasePresenter;
import com.weis.cloudcreate.utils.AcitivityUtils;
import com.weis.cloudcreate.utils.AppUtils;
import com.weis.cloudcreate.utils.StatusBarUtils;
import com.weis.cloudcreate.utils.StringUtils;
import com.weis.cloudcreate.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/7/30.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.img_exit)
    ImageView imgExit;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.img_reset)
    ImageView imgReset;
    @BindView(R.id.img_login)
    ImageView imgLogin;
    @BindView(R.id.tx_visitor)
    TextView txVisitor;
    @BindView(R.id.tx_register)
    TextView txRegister;
    @BindView(R.id.tx_qq)
    TextView txQq;
    @BindView(R.id.tx_wechat)
    TextView txWechat;
    @BindView(R.id.tx_ali)
    TextView txAli;

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        StatusBarUtils.setWindowStatusBarColor(this, R.color.color_white, 1);
    }

    @OnClick({R.id.img_exit
            , R.id.img_login
            , R.id.tx_visitor
            , R.id.tx_register
            , R.id.img_reset})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_exit:
                AcitivityUtils.AppExit(this);
                break;

            case R.id.img_login:
                checkInput();
                break;

            case R.id.tx_visitor:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;

            case R.id.tx_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;

            case R.id.img_reset:
                startActivity(new Intent(this, ResetPwdActivity.class));
                break;
        }
    }

    private void checkInput() {
        if (StringUtils.isEmpty(etName.getText().toString().trim())) {
            ToastUtils.showShort(this, "请输入姓名！");
            return;
        }
        if (StringUtils.isEmpty(etPwd.getText().toString().trim())) {
            ToastUtils.showShort(this, "请输入密码！");
            return;
        }
    }
}
