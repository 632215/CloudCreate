package com.weis.cloudcreate.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/7/31.
 */

public class DrawableUtils {

    /**
     * 设置文字的图片方向
     *
     * @param context
     * @param textView
     * @param resId
     * @param direction 0 left      1 top    2 right   3 bottom
     */
    public static void setDrawable(Context context, TextView textView, int resId, int direction) {
        Drawable drawable = context.getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        switch (direction) {
            case 0:
                textView.setCompoundDrawables(drawable, null, null, null);
                break;

            case 1:
                textView.setCompoundDrawables(null, drawable, null, null);
                break;

            case 2:
                textView.setCompoundDrawables(null, null, drawable, null);
                break;

            case 3:
                textView.setCompoundDrawables(null, null, null, drawable);
                break;
        }
    }
}
