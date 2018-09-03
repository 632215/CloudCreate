package com.weis.cloudcreate.presenter;

import android.text.TextUtils;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.view.ui.LoginView;

public class LoginPresenter extends BasePresenter<LoginView> {

    public void login(String name, String pwd) {
        if (TextUtils.isEmpty(name)) {
            toast(R.string.input_user_name);
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            toast(R.string.input_user_name);
            return;
        }
        mView.loginSucceed();
    }

}
