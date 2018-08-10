package com.weis.cloudcreate.utils;

import android.content.Context;

/**
 * Created by Administrator on 2018/8/1.
 */

public class Utils {
    private static Context context;

    public static void init(Context con) {
        context = con;
    }

    public static Context getContext() {
        return context;
    }
}
