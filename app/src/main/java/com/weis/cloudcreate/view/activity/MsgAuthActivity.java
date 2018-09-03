package com.weis.cloudcreate.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.weis.cloudcreate.R;

/**
 * Created by Administrator on 2018/7/30.
 */

public class MsgAuthActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_auth);
        initView();
    }

    protected void initView() {
        setTitleText(getString(R.string.activity_msg_confirm), View.VISIBLE);
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
