package com.weis.cloudcreate.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestOptions;
import com.weis.cloudcreate.R;
import com.weis.cloudcreate.bean.ImageSize;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

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


    public Bitmap getBitmap(final Context context, final String url){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //String url = "http://www.guolin.tech/book.png";
                    FutureTarget<File> target = Glide.with(context)
                            .asFile()
                            .load(url)
                            .submit();
                    final File imageFile = target.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return null;
    }

    //获取图片尺寸
    public static ImageSize getImageSize(Bitmap bitmap) {
        ImageSize imageSize = new ImageSize();
        if (null == bitmap || bitmap.isRecycled()) {
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] byteTmp = baos.toByteArray();
        try {
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(byteTmp, 0, byteTmp.length, bitmapOptions);
        int outWidth = bitmapOptions.outWidth;
        int outHeight = bitmapOptions.outHeight;
        int maxWidth = 400;
        int maxHeight = 400;
        int minWidth = 150;
        int minHeight = 150;
        if (outWidth / maxWidth > outHeight / maxHeight) {//
            if (outWidth >= maxWidth) {//
                imageSize.setWidth(maxWidth);
                imageSize.setHeight(outHeight * maxWidth / outWidth);
            } else {
                imageSize.setWidth(outWidth);
                imageSize.setHeight(outHeight);
            }
            if (outHeight < minHeight) {
                imageSize.setHeight(minHeight);
                int width = outWidth * minHeight / outHeight;
                if (width > maxWidth) {
                    imageSize.setWidth(maxWidth);
                } else {
                    imageSize.setWidth(width);
                }
            }
        } else {
            if (outHeight >= maxHeight) {
                imageSize.setHeight(maxHeight);
                imageSize.setWidth(outWidth * maxHeight / outHeight);
            } else {
                imageSize.setHeight(outHeight);
                imageSize.setWidth(outWidth);
            }
            if (outWidth < minWidth) {
                imageSize.setWidth(minWidth);
                int height = outHeight * minWidth / outWidth;
                if (height > maxHeight) {
                    imageSize.setHeight(maxHeight);
                } else {
                    imageSize.setHeight(height);
                }
            }
        }
        return imageSize;
    }
}
