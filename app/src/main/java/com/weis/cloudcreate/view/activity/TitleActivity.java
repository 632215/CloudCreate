package com.weis.cloudcreate.view.activity;

import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.utils.DrawableUtils;
import com.weis.cloudcreate.view.adapter.BusinessAdapter;
import com.weis.cloudcreate.view.custom.FillRecycleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/30.
 */

public class TitleActivity extends FragmentActivity {
    private  TextView txBack;
    private  TextView txTitile;
    private  TextView txPreview;
    private TextView txTitleSecond;
    private RelativeLayout rlRoot;
    private FrameLayout flRoot;
    private  ConstraintLayout clRoot;
    //聊天窗口控件
    private  ConstraintLayout clDialogTitle;
    private  TextView txDialogBack;
    private  TextView txName;
    private  TextView txDevice;
    private  ImageView imgMoreInfo;
    private  ImageView imgSearch;
    private  ImageView imgOnLine;
    private  FillRecycleView fillRecycleView;

    private BusinessAdapter businessAdapter;
    private List<String> businessList;

    //对话框更多信息按钮回调事件
    protected void onMoreInfo() {
    }

    //对话框返回按钮回调事件
    protected void dialogBback() {
    }

    //对话框直播按钮点击事件
    protected void onLine() {
    }

    //对话框搜索按钮点击事件
    protected void search() {
    }

    //前进按钮点击事件
    protected void preview() {
    }

    //返回按钮点击事件
    protected void back() {
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_title);
        clRoot = findViewById(R.id.cl_root);
        flRoot = findViewById(R.id.fl_root);
        rlRoot = findViewById(R.id.rl_root);
        txPreview = findViewById(R.id.tx_preview);
        txTitile = findViewById(R.id.tx_title);
        txBack = findViewById(R.id.tx_back);
        txTitleSecond = findViewById(R.id.tx_title_second);
        //聊天窗口控件
        clDialogTitle = findViewById(R.id.cl_dialog_title);
        txDialogBack = findViewById(R.id.tx_dialog_back);
        txName = findViewById(R.id.tx_name);
        txDevice = findViewById(R.id.tx_device);
        imgMoreInfo = findViewById(R.id.img_more_info);
        imgSearch = findViewById(R.id.img_search);
        imgOnLine = findViewById(R.id.img_online);
        fillRecycleView = findViewById(R.id.fill_recycle_view);
        txDialogBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBback();
            }
        });
        txBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });
        txPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preview();
            }
        });
        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });
        imgOnLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLine();
            }
        });
        imgMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMoreInfo();
            }
        });
        if (Build.VERSION.SDK_INT < 21) {
            clRoot.setPadding(0, 0, 0, 0);
        }

        flRoot.removeAllViews();
        View.inflate(this, layoutResID, flRoot);
        onContentChanged();
    }

    @Override
    public void setContentView(View view) {
        flRoot.removeAllViews();
        flRoot.addView(view);
        onContentChanged();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        flRoot.removeAllViews();
        flRoot.addView(view, params);
        onContentChanged();
    }

    //设置返回按钮的图标
    public void showBackView() {
        clDialogTitle.setVisibility(View.GONE);
        rlRoot.setVisibility(View.VISIBLE);
        txBack.setVisibility(View.VISIBLE);
    }

    //设置返回按钮的图标
    public void setBackView(int resId) {
        DrawableUtils.setDrawable(this, txBack, resId, 0);
    }

    //设置返回按钮的文字
    public void setBackText(String tx) {
        rlRoot.setVisibility(View.VISIBLE);
        txBack.setVisibility(View.VISIBLE);
        txBack.setText(tx);
    }

    //设置返回按钮的可见性
    public void setBackVisible(int visible) {
        txBack.setVisibility(visible);
    }

    //设置前进按钮的图标
    public void setPreviewView(int resId) {
        DrawableUtils.setDrawable(this, txPreview, resId, 3);
    }

    //设置前进按钮的文字
    public void setPreviewText(String tx, int visible) {
        txPreview.setText(tx);
        txPreview.setVisibility(visible);
    }

    //设置标题的文字
    public void setTitleText(String tx) {
        txTitile.setText(tx);
    }

    //设置标题的文字和整个title的可见性
    public void setTitleText(String tx, int visible) {
        txTitile.setText(tx);
        rlRoot.setVisibility(visible);
        clDialogTitle.setVisibility(View.GONE);
    }

    //设置副标题
    public void setTxTitleSecond(String titlesecond) {
        txTitleSecond.setText(titlesecond);
        txTitleSecond.setVisibility(View.VISIBLE);
    }

    //    获取前进按钮
    public View getPreviewView() {
        return txPreview;
    }

    public void setDialogInfo(String name, String device) {
        initBuinessData();
        rlRoot.setVisibility(View.GONE);
        clDialogTitle.setVisibility(View.VISIBLE);
        txName.setText(name);
        txDevice.setText(device);
    }

    //初始化商业行的数据
    private void initBuinessData() {
        if (businessList == null)
            businessList = new ArrayList<>();
        businessList.clear();
        businessList.add("平台");
        businessList.add("政府");
        businessList.add("股票");
        businessList.add("游戏");
        businessList.add("医疗");
        businessList.add("故事");
        businessAdapter = new BusinessAdapter(this, businessList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        fillRecycleView.setLayoutManager(linearLayoutManager);
        fillRecycleView.setAdapter(businessAdapter);
    }
}
