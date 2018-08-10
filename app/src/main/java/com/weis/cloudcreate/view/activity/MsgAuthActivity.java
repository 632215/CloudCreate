package com.weis.cloudcreate.view.activity;

import android.content.Intent;
import android.view.View;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.presenter.BasePresenter;

import butterknife.OnClick;

/**
 * Created by Administrator on 2018/7/30.
 */

public class MsgAuthActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_msg_auth;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        setTitleText(getString(R.string.activity_msg_confirm), View.VISIBLE);
    }

    @Override
    protected void back() {
        super.back();
        finish();
    }

//    @OnClick({R.id.img_sure})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.img_sure:
//                startActivity(new Intent(this, RegisterActivity.class));
//                break;
//        }
//    }
}
