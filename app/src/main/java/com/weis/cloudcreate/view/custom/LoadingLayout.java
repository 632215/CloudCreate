package com.weis.cloudcreate.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.utils.ConnectUtils;

/**
 * Created by Administrator on 2018/8/4.
 */

public class LoadingLayout extends FrameLayout {
    private static int loadingView, errorView, retryView, emptyView, successView;
    private final static int LoadingPage = 0;
    private final static int ErrorPage = 1;
    private final static int RetryPage = 2;
    private final static int EmptyPage = 3;
    private final static int SuccessPage = 4;
    private static Context context;

    public LoadingLayout(Context context) {
        super(context);
        this.context = context;
    }

    public LoadingLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public LoadingLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        TypedArray typedArray = context.getTheme()
                .obtainStyledAttributes(attrs, R.styleable.LoadingLayout, 0, 0);
        try {
            loadingView = typedArray.getResourceId(R.styleable.LoadingLayout_loadingView, R.layout.loadlayout_loading);
            errorView = typedArray.getResourceId(R.styleable.LoadingLayout_errorView, R.layout.loadlayout_error);
            retryView = typedArray.getResourceId(R.styleable.LoadingLayout_retryView, R.layout.loadlayout_retry);
            emptyView = typedArray.getResourceId(R.styleable.LoadingLayout_emptyView, R.layout.loadlayout_empty);
            successView = typedArray.getResourceId(R.styleable.LoadingLayout_successView, R.layout.loadlayout_success);

            LayoutInflater inflater = LayoutInflater.from(getContext());
            inflater.inflate(loadingView, this, true);
            inflater.inflate(errorView, this, true);
            inflater.inflate(retryView, this, true);
            inflater.inflate(emptyView, this, true);
            inflater.inflate(successView, this, true);
            setState(SuccessPage);
        } catch (Exception e) {
            typedArray.recycle();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        for (int x = 0; x < getChildCount() - 1; x++)
            getChildAt(x).setVisibility(GONE);
    }

    public void setState(int state) {
        for (int x = 0; x < getChildCount() - 1; x++)
            getChildAt(x).setVisibility(GONE);
        if (!ConnectUtils.isNetworkConnected(context))
            state = 1;
        switch (state) {
            case LoadingPage:
                getChildAt(0).setVisibility(VISIBLE);
                break;

            case ErrorPage:
                getChildAt(1).setVisibility(VISIBLE);
                break;

            case RetryPage:
                getChildAt(2).setVisibility(VISIBLE);
                break;

            case EmptyPage:
                getChildAt(3).setVisibility(VISIBLE);
                break;

            case SuccessPage:
                getChildAt(4).setVisibility(VISIBLE);
                break;
        }
    }
}
