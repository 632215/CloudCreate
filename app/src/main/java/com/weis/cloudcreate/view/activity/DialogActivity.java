package com.weis.cloudcreate.view.activity;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.bean.DialogBean;
import com.weis.cloudcreate.bean.MsgBean;
import com.weis.cloudcreate.presenter.BasePresenter;
import com.weis.cloudcreate.utils.AndroidUtils;
import com.weis.cloudcreate.utils.ToastUtils;
import com.weis.cloudcreate.view.adapter.DialogAdapter;
import com.weis.cloudcreate.view.custom.FillRecycleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DialogActivity extends BaseActivity {
    @BindView(R.id.recycle_view_dialog)
    FillRecycleView recycleViewDialog;
    @BindView(R.id.img_input_type)
    ImageView imgVoice;
    @BindView(R.id.img_more)
    ImageView imgMore;
    @BindView(R.id.img_fee)
    ImageView imgFee;
    @BindView(R.id.et_input)
    EditText etInput;
    @BindView(R.id.cl_input_bottom)
    ConstraintLayout clInputBottom;
    @BindView(R.id.btn_voice)
    Button btnVoice;

    private MsgBean bean = null;
    private DialogAdapter dialogAdapter;
    private List<DialogBean> dialoList = new ArrayList<>();

    @Override
    protected int getContentView() {
        return R.layout.activity_dialog;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        bean = (MsgBean) getIntent().getSerializableExtra("MsgBean");
        if (bean != null) {
            setDialogInfo(bean.getName(), AndroidUtils.getDeviceModel() + getString(R.string.activity_dialog_online));
        }
        initDialogData();
    }

    //初始化对话消息
    private void initDialogData() {
        if (dialogAdapter == null)
            dialogAdapter = new DialogAdapter(this, dialoList);
        dialoList.clear();
        dialoList.add(new DialogBean(0, 0, "","","你好","",""));
        dialoList.add(new DialogBean(1, 0, "","","你好呀","",""));
        dialoList.add(new DialogBean(0, 1, "","","初次认识","",""));
        dialoList.add(new DialogBean(0, 1, "","","那你是哪里人呀","",""));
        dialoList.add(new DialogBean(1, 0, "","","你好","",""));
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        recycleViewDialog.setLayoutManager(linearLayoutManager);
        recycleViewDialog.setAdapter(dialogAdapter);
    }

    @Override
    protected void dialogBback() {
        super.dialogBback();
        finish();
    }

    @Override
    protected void preview() {
        super.preview();
        startActivity(new Intent(this, PersonInfoActivity.class));
    }

    @Override
    protected void onLine() {
        super.onLine();
        ToastUtils.showShort(this, "直播");
    }

    @Override
    protected void search() {
        super.search();
        ToastUtils.showShort(this, "搜索");
    }

    @OnClick({R.id.img_input_type
            , R.id.img_more
            , R.id.img_fee
            , R.id.fill_recycle_view
            , R.id.et_input
            , R.id.btn_voice
            , R.id.scroll_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_input_type:
                imgVoice.setImageDrawable(etInput.getVisibility() == View.VISIBLE
                        ? getResources().getDrawable(R.mipmap.icon_dialog_text)
                        : getResources().getDrawable(R.mipmap.icon_dialog_voice));
                etInput.setVisibility(etInput.getVisibility() == View.VISIBLE
                        ? View.GONE
                        : View.VISIBLE);
                btnVoice.setVisibility(etInput.getVisibility() == View.VISIBLE
                        ? View.GONE
                        : View.VISIBLE);
                break;

            case R.id.img_more:
                clInputBottom.setVisibility(clInputBottom.getVisibility() == View.VISIBLE
                        ? View.GONE
                        : View.VISIBLE);
                break;

            case R.id.img_fee:
                clInputBottom.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (clInputBottom.getVisibility() == View.VISIBLE)
            clInputBottom.setVisibility(View.GONE);
        return super.dispatchTouchEvent(ev);
    }
}