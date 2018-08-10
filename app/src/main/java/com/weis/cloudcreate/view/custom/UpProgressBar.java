package com.weis.cloudcreate.view.custom;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ProgressBar;

import com.weis.cloudcreate.utils.LogUtils;

/**
 * Created by Administrator on 2018/8/1.
 */

public class UpProgressBar extends Handler {
    private Context mContext;
    ProgressBar bar;

    public UpProgressBar(Context mContext, @NonNull ProgressBar bar) {
        this.mContext = mContext.getApplicationContext();
        this.bar = bar;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        bar.setProgress((int) msg.obj);
    }

    public void updata(int number) {
        LogUtils.e(number);
        if (number >= 100) {
            bar.setVisibility(View.GONE);
        } else {
            Message message = new Message();
            message.obj = number;
            sendMessage(message);
        }
    }

    /**
     * Sync Cookie
     */
    public static void syncCookie(Context mContext, String url) {
//        try {
//            CookieSyncManager.createInstance(mContext);
//            CookieManager cookieManager = CookieManager.getInstance();
//            cookieManager.setAcceptCookie(true);
//            cookieManager.removeSessionCookie();// 移除
//            cookieManager.removeAllCookie();
//            String oldCookie = cookieManager.getCookie(url);
//            UrlConfigBean urlConfigBean = MyApplication.getInstance().getUrlConfigBean();
//            if (urlConfigBean != null) {
//                if (StringUtils.isEmpty(urlConfigBean.getAccessTokenCookieName())) {
//                    ToastUtils.showLong(mContext, "url参数配置为空！");
//                    return;
//                }
//                if (StringUtils.isEmpty(MyApplication.getBaseUserBean().getAccessToken())) {
//                    ToastUtils.showLong(mContext, "用户登录唯一标识为空！");
//                    return;
//                }
//                String cookic = urlConfigBean.getAccessTokenCookieName() + "=" + MyApplication.getBaseUserBean().getAccessToken();
//                cookieManager.setCookie(url, cookic);
//                if (MyApplication.getBaseUserBean().getPlatformName().equals("WEIXIN")) {
//                    cookieManager.setCookie(url, urlConfigBean.getTokenTypeCookieName() + "=" + "wechat");
//                } else {
//                    if (StringUtils.isEmpty(MyApplication.getBaseUserBean().getPlatformName()))
//                        cookieManager.setCookie(url, urlConfigBean.getTokenTypeCookieName() + "=QQ");
//                    else
//                        cookieManager.setCookie(url, urlConfigBean.getTokenTypeCookieName() + "=" + MyApplication.getBaseUserBean().getPlatformName());
//                }
//                if (Build.VERSION.SDK_INT < 21) {
//                    CookieSyncManager.getInstance().sync();
//                } else {
//                    CookieManager.getInstance().flush();
//                }
//            }
//            String newCookie = cookieManager.getCookie(url);
//            LogUtils.i("newCookie-----" + newCookie);
//            if (newCookie != null) {
//                LogUtils.i(newCookie);
//            }
//        } catch (Exception e) {
//            LogUtils.i(e.toString());
//        }
    }
}
