package com.weis.cloudcreate.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.utils.DrawableUtils;

/**
 * Created by Administrator on 2018/7/30.
 */

public class TitleActivity extends FragmentActivity {
    TextView txBack;
    TextView txTitile;
    TextView txPreview;
    TextView txTitleSecond;
    RelativeLayout rlRoot;
    FrameLayout flRoot;
    ConstraintLayout clRoot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.title_activity);
        clRoot = findViewById(R.id.cl_root);
        flRoot = findViewById(R.id.fl_root);
        rlRoot = findViewById(R.id.rl_root);
        txPreview = findViewById(R.id.tx_preview);
        txTitile = findViewById(R.id.tx_title);
        txBack = findViewById(R.id.tx_back);
        txTitleSecond = findViewById(R.id.tx_title_second);
        txBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
        txPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview();
            }
        });
        if (Build.VERSION.SDK_INT < 21) {
            clRoot.setPadding(0, 0, 0, 0);
        }
    }

    //前进按钮点击事件
    protected void preview() {
    }

    //返回按钮点击事件
    protected void back() {
    }

    @Override
    public void setContentView(int layoutResID) {
        flRoot.removeAllViews();
        View.inflate(this, layoutResID, flRoot);
        onContentChanged();
    }

    @Override
    public void setContentView(View view) {
        flRoot.removeAllViews();
        flRoot.addView(view);
        onContentChanged();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        flRoot.removeAllViews();
        flRoot.addView(view, params);
        onContentChanged();
    }

    //设置返回按钮的图标
    public void showBackView() {
        rlRoot.setVisibility(View.VISIBLE);
    }

    //设置返回按钮的图标
    public void setBackView(int resId) {
        DrawableUtils.setDrawable(this, txBack, resId, 0);
    }

    //设置返回按钮的文字
    public void setBackText(String tx) {
        txBack.setText(tx);
    }

    //设置返回按钮的可见性
    public void setBackVisible(int visible) {
        txBack.setVisibility(visible);
    }

    //设置前进按钮的图标
    public void setPreviewView(int resId) {
        DrawableUtils.setDrawable(this, txPreview, resId, 3);
    }

    //设置前进按钮的文字
    public void setPreviewText(String tx, int visible) {
        txPreview.setText(tx);
        txPreview.setVisibility(visible);
    }

    //设置标题的文字
    public void setTitleText(String tx) {
        txTitile.setText(tx);
    }

    //设置标题的文字和整个title的可见性
    public void setTitleText(String tx, int visible) {
        txTitile.setText(tx);
        rlRoot.setVisibility(visible);
    }

    public void setTxTitleSecond(String titlesecond) {
        txTitleSecond.setText(titlesecond);
        txTitleSecond.setVisibility(View.VISIBLE);
    }
}
