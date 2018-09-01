package com.weis.cloudcreate.view.custom;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.utils.ToastUtils;
import com.weis.cloudcreate.view.activity.CreateGroupActivity;
import com.weis.cloudcreate.view.activity.MainActivity;
import com.weis.cloudcreate.view.activity.MyPackageActivity;
import com.weis.cloudcreate.view.adapter.StringAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.weis.cloudcreate.R.color.white;

/**
 * Created by Administrator on 2018/8/5.
 */

public class CreateGroupWindow extends PopupWindow implements StringAdapter.ItemOnClickListener {
    private PopupWindow popupWindow;
    private Context context;
    private FillRecycleView fillRecycleView;
    private TextView txTitle;
    private StringAdapter adapter;
    private List<String> dataList = new ArrayList<>();
    private CreateGroupWindowListener listener;
    private View parent;

    public CreateGroupWindow(CreateGroupWindowListener listener) {
        this.listener = listener;
    }

    public CreateGroupWindow(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public void initPopupWindow(final Context context, View parent, List dataList) {
        this.context = context;
        this.parent = parent;
        View view = View.inflate(context, R.layout.popup_create_group, null);
        if (popupWindow == null) {
            popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
            popupWindow.setTouchable(true);
            popupWindow.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shape_et_white_bg));
        }
        fillRecycleView = view.findViewById(R.id.fill_recycle_view);
        txTitle = view.findViewById(R.id.tx_title);
        initAdapter(dataList);
        popupWindow.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                ((CreateGroupActivity) context).changeUiAlpha(1.0f);
            }
        });
    }

    private void showWindows(Context context, View parent) {
        //        popupWindow.showAsDropDown(parent);//在父的下方出现
        popupWindow.showAtLocation(parent, Gravity.CENTER, 0, 0);
        ((CreateGroupActivity) context).changeUiAlpha(0.5f);
    }

    private void initAdapter(List dataList) {
        this.dataList = dataList;
        adapter = new StringAdapter(context, dataList);
        adapter.setListener(this);
        fillRecycleView.setLayoutManager(new LinearLayoutManager(context));
        fillRecycleView.setAdapter(adapter);
    }

    public void setTxTitle(String title) {
        txTitle.setText(title);
    }

    public void setDataList(List<String> dataList) {
        this.dataList = dataList;
        adapter.setDataList(dataList);
        showWindows(context, parent);
    }

    @Override
    public void onItemOnClick(int position) {
        if (popupWindow != null && popupWindow.isShowing())
            popupWindow.dismiss();
        if (dataList != null && dataList.size() > position)
            listener.onItemOnClick(parent, position);
    }

    public interface CreateGroupWindowListener {
        void onItemOnClick(View parent, int position);
    }
}
