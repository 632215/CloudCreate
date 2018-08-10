package com.weis.cloudcreate.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.bean.AddHumanBean;
import com.weis.cloudcreate.presenter.BasePresenter;
import com.weis.cloudcreate.view.adapter.AddHumanAdapter;
import com.weis.cloudcreate.view.custom.FillRecycleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/8/6.
 */

public class AddHumanFragment extends BaseFragment {
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.fill_recycle_view)
    FillRecycleView fillRecycleView;
    @BindView(R.id.tx_more)
    TextView txMore;

    private List<AddHumanBean> dataList = null;
    private AddHumanAdapter addHumanAdapter;

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
        dataList.add(new AddHumanBean(""
                , "添加手机联系人"
                , ""
                , "23"
                , ""
                , "添加或者邀请通讯录中的好友"));
        dataList.add(new AddHumanBean(""
                , "张三"
                , "1256378"
                , "22"
                , "female"
                , "吃"));
        dataList.add(new AddHumanBean(""
                , "里斯"
                , "1214256"
                , "23"
                , "male"
                , "喝"));
        dataList.add(new AddHumanBean(""
                , "里斯"
                , "1214256"
                , "23"
                , "male"
                , "喝"));
        dataList.add(new AddHumanBean(""
                , "里斯"
                , "1214256"
                , "23"
                , "male"
                , "喝"));
        dataList.add(new AddHumanBean(""
                , "里斯"
                , "1214256"
                , "23"
                , "male"
                , "喝"));
        dataList.add(new AddHumanBean(""
                , "里斯"
                , "1214256"
                , "23"
                , "male"
                , "喝"));
        dataList.add(new AddHumanBean(""
                , "里斯"
                , "1214256"
                , "23"
                , "male"
                , "喝"));
        dataList.add(new AddHumanBean(""
                , "里斯"
                , "1214256"
                , "23"
                , "male"
                , "喝"));
        dataList.add(new AddHumanBean(""
                , "里斯"
                , "1214256"
                , "23"
                , "male"
                , "喝"));
        addHumanAdapter = new AddHumanAdapter(getContext(), dataList);
        fillRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        fillRecycleView.setAdapter(addHumanAdapter);
    }
}
