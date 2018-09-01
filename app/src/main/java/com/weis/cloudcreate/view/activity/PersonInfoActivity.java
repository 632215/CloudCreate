package com.weis.cloudcreate.view.activity;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.presenter.BasePresenter;
import com.weis.cloudcreate.utils.GlideUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonInfoActivity extends BaseActivity {
    @BindView(R.id.img_head)
    ImageView imgHead;
    @BindView(R.id.tx_name)
    TextView txName;
    @BindView(R.id.tx_account)
    TextView txAccount;
    @BindView(R.id.cl_info)
    ConstraintLayout clInfo;

    @Override
    protected int getContentView() {
        return R.layout.activity_person_info;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        GlideUtils.setImageId(this, R.mipmap.ic_launcher_round, imgHead, true);
        txName.setText("Lisa");
        txAccount.setText(getString(R.string.activity_person_info_account) + "13125263");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
