package com.weis.cloudcreate.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.presenter.BasePresenter;
import com.weis.cloudcreate.utils.AcitivityUtils;
import com.weis.cloudcreate.utils.ConnectUtils;
import com.weis.cloudcreate.utils.StatusBarUtils;
import com.weis.cloudcreate.utils.ToastUtils;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/30.
 */

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends TitleActivity {
    private T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        if (!ConnectUtils.isNetworkConnected(this))
            ToastUtils.showLong(this, getString(R.string.app_net_tips));
        StatusBarUtils.setWindowStatusBarColor(this, R.color.title_bg, 0);
        ButterKnife.bind(this);
        AcitivityUtils.addActivity(this);
        presenter = setPresenter();
        if (presenter != null)
            presenter.attach((V) this);
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.disAttach();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //监听用户点击屏幕事件，进行拦截
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View view = getCurrentFocus();
            //判断当前获取的焦点是否在Editext上面
            if (StatusBarUtils.isShouldHideInput(view, ev)) {
                hideSoftInput(view.getWindowToken());//关闭软键盘
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 隐藏软件盘
     *
     * @param token
     */
    private void hideSoftInput(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token,
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    protected abstract int getContentView();

    protected abstract T setPresenter();

    protected abstract void initView();
}
