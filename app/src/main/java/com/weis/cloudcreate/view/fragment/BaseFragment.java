package com.weis.cloudcreate.view.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.utils.PresenterInjector;
import com.weis.cloudcreate.view.BaseView;
import com.weis.cloudcreate.view.activity.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/31.
 */

public abstract class BaseFragment extends Fragment implements BaseView{
    protected BaseActivity mActivity;
    private RelativeLayout rlTitle;
    private TextView txBack;
    private TextView txTitle;
    private TextView txPreview;
    private TextView txLine;
    private FrameLayout flContent;
    protected ProgressDialog progressDialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        initChild(view, inflater);
        ButterKnife.bind(this, view);
        PresenterInjector.inject(this);
        initView(view, savedInstanceState);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (BaseActivity) context;
    }

    private void initChild(View view, LayoutInflater inflater) {
        rlTitle = view.findViewById(R.id.rl_title);
        txBack = view.findViewById(R.id.tx_back);
        txTitle = view.findViewById(R.id.tx_title);
        txPreview = view.findViewById(R.id.tx_preview);
        flContent = view.findViewById(R.id.fl_content);
        flContent.removeAllViews();
        View child = inflater.inflate(getContentView(), null);
        flContent.addView(child);
        txPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onForward();
            }
        });
    }

    //前进按钮 点击事件
    private void onForward() {
    }

    protected abstract int getContentView();

    protected abstract void initView(View view, Bundle savedInstanceState);

    @Override
    public void toast(int msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        showProgress(R.string.please_wait);
    }

    @Override
    public void showProgress(int msg) {
        showProgress(getString(msg));
    }

    @Override
    public void showProgress(String msg) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivity());
        }
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    @Override
    public void dismissProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public Intent getIntent() {
        return null;
    }
}
