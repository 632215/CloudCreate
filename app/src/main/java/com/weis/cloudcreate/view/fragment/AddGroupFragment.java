package com.weis.cloudcreate.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.bean.AddGroupBean;
import com.weis.cloudcreate.bean.AddHumanBean;
import com.weis.cloudcreate.presenter.BasePresenter;
import com.weis.cloudcreate.view.adapter.AddGroupAdapter;
import com.weis.cloudcreate.view.adapter.AddHumanAdapter;
import com.weis.cloudcreate.view.custom.FillRecycleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/8/6.
 */

public class AddGroupFragment extends BaseFragment {
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.fill_recycle_view)
    FillRecycleView fillRecycleView;
    @BindView(R.id.tx_more)
    TextView txMore;

    private List<AddGroupBean> dataList = null;
    private AddGroupAdapter addGroupAdapter;

    @Override
    protected int getContentView() {
        return R.layout.fragment_add;
    }

    @Override
    BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        dataList = new ArrayList<>();
        dataList.add(new AddGroupBean(""
                , "面对面加群"
                , "22"
                , "妹子多"
                , "添加身边的人和群"));
        dataList.add(new AddGroupBean(""
                , "群a"
                , "22"
                , "妹子多"
                , "游戏"));
        dataList.add(new AddGroupBean(""
                , "群a"
                , "22"
                , "妹子多"
                , "游戏"));
        dataList.add(new AddGroupBean(""
                , "群a"
                , "22"
                , "妹子多"
                , "游戏"));
        dataList.add(new AddGroupBean(""
                , "群a"
                , "22"
                , "妹子多"
                , "游戏"));
        dataList.add(new AddGroupBean(""
                , "群a"
                , "22"
                , "妹子多"
                , "游戏"));
        dataList.add(new AddGroupBean(""
                , "群a"
                , "22"
                , "妹子多"
                , "游戏"));
        dataList.add(new AddGroupBean(""
                , "群a"
                , "22"
                , "妹子多"
                , "游戏"));
        dataList.add(new AddGroupBean(""
                , "群a"
                , "22"
                , "妹子多"
                , "游戏"));
        addGroupAdapter = new AddGroupAdapter(getContext(), dataList);
        fillRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        fillRecycleView.setAdapter(addGroupAdapter);
    }
}
