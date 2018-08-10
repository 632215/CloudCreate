package com.weis.cloudcreate.view.activity;

import android.view.View;
import android.widget.ImageView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.presenter.BasePresenter;
import com.weis.cloudcreate.utils.GlideUtils;

import butterknife.BindView;

public class CreateGroupActivity extends BaseActivity {
    @BindView(R.id.img_head)
    ImageView imgHead;

    @Override
    protected int getContentView() {
        return R.layout.activity_create_group;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        setTitleText(getString(R.string.activity_create_public_title), View.VISIBLE);
        setTxTitleSecond(getString(R.string.activity_create_public_title_second));
        setPreviewText(getString(R.string.activity_create_public_submit), View.VISIBLE);
        GlideUtils.setImageId(this, R.drawable.shape_circle_head, imgHead, true);
    }

    @Override
    protected void back() {
        super.back();
        finish();
    }

    @Override
    protected void preview() {
        super.preview();
    }
}
