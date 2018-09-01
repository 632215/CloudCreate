package com.weis.cloudcreate.view.custom;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.view.activity.AddActivity;
import com.weis.cloudcreate.view.activity.CreateGroupActivity;
import com.weis.cloudcreate.view.activity.MainActivity;

/**
 * Created by Administrator on 2018/8/5.
 */

public class AddPopupWindow extends PopupWindow implements View.OnClickListener {
    private PopupWindow popupWindow;
    private Context context;
    ConstraintLayout clAddGroup;
    ConstraintLayout clAddFriend;
    ConstraintLayout clCreateGroup;
    ConstraintLayout clScan;
    ConstraintLayout clPay;
    ConstraintLayout clHelp;

    public void initPopupWindow(final Context context, View parent) {
        this.context = context;
        View view = View.inflate(context, R.layout.popup_add, null);
        if (popupWindow == null) {
            popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
            popupWindow.setTouchable(true);
            popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.mipmap.icon_popu_bg));
            popupWindow.setWidth(BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_popu_bg).getWidth());
        }
        clAddGroup = view.findViewById(R.id.cl_add_group);
        clAddGroup.setOnClickListener(this);
        clAddFriend = view.findViewById(R.id.cl_add_friend);
        clAddFriend.setOnClickListener(this);
        clCreateGroup = view.findViewById(R.id.cl_create_group);
        clCreateGroup.setOnClickListener(this);
        clScan = view.findViewById(R.id.cl_scan);
        clScan.setOnClickListener(this);
        clPay = view.findViewById(R.id.cl_pay);
        clPay.setOnClickListener(this);
        clHelp = view.findViewById(R.id.cl_help);
        clHelp.setOnClickListener(this);
        WindowManager manager = (WindowManager) context.getSystemService(MainActivity.WINDOW_SERVICE);
        int windowsX = manager.getDefaultDisplay().getWidth();
        popupWindow.getContentView().measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int popupWindowX = popupWindow.getContentView().getMeasuredWidth();
//        popupWindow.showAsDropDown(parent, windowsX - BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_popu_bg).getWidth() - 150, 0);
        popupWindow.showAtLocation(parent, Gravity.NO_GRAVITY, windowsX - popupWindowX - 20, 200);

        ((MainActivity) context).changeUiAlpha(0.5f);
        popupWindow.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                ((MainActivity) context).changeUiAlpha(1.0f);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (popupWindow != null && popupWindow.isShowing())
            popupWindow.dismiss();
        switch (view.getId()) {
            case R.id.cl_add_group:
                context.startActivity(new Intent(context, AddActivity.class).putExtra("index",1));
                break;

            case R.id.cl_add_friend:
                context.startActivity(new Intent(context, AddActivity.class).putExtra("index",0));
                break;

            case R.id.cl_create_group:
                context.startActivity(new Intent(context, CreateGroupActivity.class));
                break;

            case R.id.cl_scan:
                break;

            case R.id.cl_pay:
                break;

            case R.id.cl_help:
                break;
        }
    }
}
