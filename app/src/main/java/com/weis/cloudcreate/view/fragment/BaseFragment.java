package com.weis.cloudcreate.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.presenter.BasePresenter;
import com.weis.cloudcreate.view.activity.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/31.
 */

public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {
    protected BaseActivity mActivity;
    private T presenter;
    private RelativeLayout rlTitle;
    private TextView txBack;
    private TextView txTitle;
    private TextView txPreview;
    private TextView txLine;
    private FrameLayout flContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        initChild(view, inflater);
        ButterKnife.bind(this, view);
        presenter = setPresenter();
        if (null != presenter)
            presenter.attach((V) this);
        initView(view, savedInstanceState);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (BaseActivity) context;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (null != presenter)
            presenter.attach((V) this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != presenter)
            presenter.disAttach();
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

    abstract T setPresenter();

    protected abstract void initView(View view, Bundle savedInstanceState);
}
