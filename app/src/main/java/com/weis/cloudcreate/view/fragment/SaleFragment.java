package com.weis.cloudcreate.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.weis.cloudcreate.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/8/3.
 */

public class SaleFragment extends BaseFragment {
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected int getContentView() {
        return R.layout.fragment_sale;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        textView.setText("热卖");
    }
}
