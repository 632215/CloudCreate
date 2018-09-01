package com.weis.cloudcreate.view.activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.presenter.BasePresenter;
import com.weis.cloudcreate.view.custom.AddPopupWindow;
import com.weis.cloudcreate.view.custom.PackagePopupWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyPackageActivity extends BaseActivity {
    @BindView(R.id.tx_charge_value)
    TextView txChargeValue;
    private PackagePopupWindow packagePopupWindow;

    @Override
    protected int getContentView() {
        return R.layout.activity_my_package;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        setTitleText(getString(R.string.activity_my_package), View.VISIBLE);
        setPreviewText(getString(R.string.activity_my_package_control), View.VISIBLE);
        txChargeValue.setText("￥0.00");
    }

    @Override
    protected void back() {
        super.back();
        finish();
    }

    @Override
    protected void preview() {
        super.preview();
        if (packagePopupWindow == null)
            packagePopupWindow = new PackagePopupWindow();
        packagePopupWindow.initPopupWindow(this, getPreviewView());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rl_charge, R.id.tx_recharge, R.id.tx_card, R.id.tx_transfer, R.id.tx_receivables})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_charge:
                break;
            case R.id.tx_recharge:
                break;
            case R.id.tx_card:
                break;
            case R.id.tx_transfer:
                break;
            case R.id.tx_receivables:
                break;
        }
    }

    //提供给popupWindows修改首页背景色方法
    public void changeUiAlpha(Float alpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = alpha;
        getWindow().setAttributes(lp);
    }
}
