package com.weis.cloudcreate.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.bean.MsgBean;
import com.weis.cloudcreate.presenter.BasePresenter;
import com.weis.cloudcreate.view.adapter.MsgAdapter;
import com.weis.cloudcreate.view.custom.FillRecycleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/8/3.
 */

public class MsgFragment extends BaseFragment {
    @BindView(R.id.recycle_view)
    FillRecycleView recycleView;

    private MsgAdapter msgAdapter = null;
    private List<MsgBean> list = null;

    @Override
    protected int getContentView() {
        return R.layout.fragment_msg;
    }

    @Override
    BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        list = new ArrayList<>();
        list.add(new MsgBean(R.mipmap.ic_launcher_round, "hello", "你好", "2"));
        list.add(new MsgBean(R.mipmap.ic_launcher_round, "hello", "你好", "3"));
        list.add(new MsgBean(R.mipmap.ic_launcher_round, "hello", "你好", "4"));
        list.add(new MsgBean(R.mipmap.ic_launcher_round, "hello", "你好", "4"));
        list.add(new MsgBean(R.mipmap.ic_launcher_round, "hello", "你好", "4"));
        list.add(new MsgBean(R.mipmap.ic_launcher_round, "hello", "你好", "4"));
        list.add(new MsgBean(R.mipmap.ic_launcher_round, "hello", "你好", "4"));
        list.add(new MsgBean(R.mipmap.ic_launcher_round, "hello", "你好", "4"));
        list.add(new MsgBean(R.mipmap.ic_launcher_round, "hello", "你好", "4"));
        list.add(new MsgBean(R.mipmap.ic_launcher_round, "hello", "你好", "4"));
        list.add(new MsgBean(R.mipmap.ic_launcher_round, "hello", "你好", "4"));
        msgAdapter = new MsgAdapter(getContext(), list);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleView.setAdapter(msgAdapter);
    }
}
