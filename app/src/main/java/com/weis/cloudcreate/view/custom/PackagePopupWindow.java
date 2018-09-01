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
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.view.activity.AddActivity;
import com.weis.cloudcreate.view.activity.CreateGroupActivity;
import com.weis.cloudcreate.view.activity.MainActivity;
import com.weis.cloudcreate.view.activity.MyPackageActivity;

/**
 * Created by Administrator on 2018/8/5.
 */

public class PackagePopupWindow extends PopupWindow implements View.OnClickListener {
    private PopupWindow popupWindow;
    private Context context;
    TextView txRecord;
    TextView txUpdate;
    TextView txFind;

    public void initPopupWindow(final Context context, View parent) {
        this.context = context;
        View view = View.inflate(context, R.layout.popup_package, null);
        if (popupWindow == null) {
            popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
            popupWindow.setTouchable(true);
            popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.mipmap.icon_my_package_bg));
            popupWindow.setWidth(BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_my_package_bg).getWidth());
        }
        txRecord = view.findViewById(R.id.tx_record);
        txRecord.setOnClickListener(this);
        txUpdate = view.findViewById(R.id.tx_update);
        txUpdate.setOnClickListener(this);
        txFind = view.findViewById(R.id.tx_find);
        txFind.setOnClickListener(this);

        WindowManager manager = (WindowManager) context.getSystemService(MainActivity.WINDOW_SERVICE);
        int windowsX = manager.getDefaultDisplay().getWidth();
        popupWindow.getContentView().measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int popupWindowX = popupWindow.getContentView().getMeasuredWidth();
//        popupWindow.showAsDropDown(parent, windowsX - BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon_popu_bg).getWidth() - 150, 0);
        popupWindow.showAtLocation(parent, Gravity.NO_GRAVITY, windowsX - popupWindowX - 20, 200);
        ((MyPackageActivity) context).changeUiAlpha(0.5f);
        popupWindow.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                ((MyPackageActivity) context).changeUiAlpha(1.0f);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (popupWindow != null && popupWindow.isShowing())
            popupWindow.dismiss();
        switch (view.getId()) {
            case R.id.tx_record:
                break;

            case R.id.tx_update:
                break;

            case R.id.tx_find:
                break;
        }
    }
}
