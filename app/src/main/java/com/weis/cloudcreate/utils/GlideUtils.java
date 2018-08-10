package com.weis.cloudcreate.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.weis.cloudcreate.R;

public class GlideUtils {
    private static RequestOptions requestOptions;
    private final static int placeholderId = R.mipmap.icon_fail_pic;
    private final static int errorId = R.mipmap.icon_fail_pic;

    private static void setPlacePic() {
        requestOptions = new RequestOptions()
//                .placeholder(placeholderId)
                .error(errorId)
                .fallback(errorId);
    }

    private static void setPlacePicWithSize(int width, int height) {
        requestOptions = new RequestOptions()
//                .placeholder(placeholderId)
                .error(errorId)
                .fallback(errorId)
                .override(width, height);
    }

    /**
     * 加载URL的图片
     *
     * @param context
     * @param url
     * @param view
     * @param isCircle
     */
    public static void setImageURL(Context context, String url, View view, boolean isCircle) {
        setPlacePic();
        if (isCircle) {
            requestOptions.circleCrop();
            Glide.with(context)
                    .load(url)
                    .apply(requestOptions)
                    .into((ImageView) view);
        } else
            Glide.with(context)
                    .load(url)
                    .apply(requestOptions)
                    .into((ImageView) view);
    }

    /**
     * 加载id的图片
     *
     * @param context
     * @param resId
     * @param view
     * @param isCircle
     */
    public static void setImageId(Context context, int resId, View view, boolean isCircle) {
        setPlacePic();
        if (isCircle) {
            requestOptions.circleCrop();
            Glide.with(context)
                    .load(resId)
                    .apply(requestOptions)
                    .into((ImageView) view);
        } else
            Glide.with(context)
                    .load(resId)
                    .apply(requestOptions)
                    .into((ImageView) view);
    }


    /**
     * 加载URL的图片指定大小
     *
     * @param context
     * @param url
     * @param view
     * @param isCircle
     * @param width
     * @param height
     */
    public static void setImageURLWithSzie(Context context, String url, View view, boolean isCircle, int width, int height) {
        setPlacePicWithSize(width, height);
        if (isCircle) {
            requestOptions.circleCrop();
            Glide.with(context)
                    .load(url)
                    .apply(requestOptions)
                    .into((ImageView) view);
        } else
            Glide.with(context)
                    .load(url)
                    .apply(requestOptions)
                    .into((ImageView) view);
    }

    /**
     * 加载URL的图片
     *
     * @param context
     * @param resId
     * @param view
     * @param isCircle
     * @param width
     * @param height
     */
    public static void setImageIdWithSzie(Context context, int resId, View view, boolean isCircle, int width, int height) {
        setPlacePicWithSize(width, height);
        if (isCircle) {
            requestOptions.circleCrop();
            Glide.with(context)
                    .load(resId)
                    .apply(requestOptions)
                    .into((ImageView) view);
        } else
            Glide.with(context)
                    .load(resId)
                    .apply(requestOptions)
                    .into((ImageView) view);
    }
}
