package com.weis.cloudcreate.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.bean.AddPublicBean;
import com.weis.cloudcreate.view.adapter.AddPublicAdapter;
import com.weis.cloudcreate.view.custom.FillRecycleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/8/6.
 */

public class AddPublicFragment extends BaseFragment {
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.fill_recycle_view)
    FillRecycleView fillRecycleView;
    @BindView(R.id.tx_title)
    TextView txTitle;
    @BindView(R.id.tx_more)
    TextView txMore;

    private List<AddPublicBean> dataList = null;
    private AddPublicAdapter addPublicAdapter;

    @Override
    protected int getContentView() {
        return R.layout.fragment_add;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        txTitle.setVisibility(View.VISIBLE);
        dataList = new ArrayList<>();
        dataList.add(new AddPublicBean(
                ""
                , "重庆生活"
                , "特色美食、旅游"));
        dataList.add(new AddPublicBean(
                ""
                , "重庆生活"
                , "特色美食、旅游"));
        dataList.add(new AddPublicBean(
                ""
                , "重庆生活"
                , "特色美食、旅游"));
        dataList.add(new AddPublicBean(
                ""
                , "重庆生活"
                , "特色美食、旅游"));
        dataList.add(new AddPublicBean(
                ""
                , "重庆生活"
                , "特色美食、旅游"));
        dataList.add(new AddPublicBean(
                ""
                , "重庆生活"
                , "特色美食、旅游"));
        dataList.add(new AddPublicBean(
                ""
                , "重庆生活"
                , "特色美食、旅游"));
        addPublicAdapter = new AddPublicAdapter(getContext(), dataList);
        fillRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        fillRecycleView.setAdapter(addPublicAdapter);
    }
}
