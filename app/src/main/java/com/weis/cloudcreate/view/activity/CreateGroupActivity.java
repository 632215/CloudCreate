package com.weis.cloudcreate.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.weis.cloudcreate.R;
import com.weis.cloudcreate.third.image.ImagePicker;
import com.weis.cloudcreate.third.image.bean.ImageItem;
import com.weis.cloudcreate.third.image.ui.ImageGridActivity;
import com.weis.cloudcreate.utils.GlideUtils;
import com.weis.cloudcreate.utils.PictureUtils;
import com.weis.cloudcreate.utils.ToastUtils;
import com.weis.cloudcreate.view.custom.CreateGroupWindow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CreateGroupActivity extends BaseActivity implements CreateGroupWindow.CreateGroupWindowListener {
    @BindView(R.id.img_head)
    ImageView imgHead;
    @BindView(R.id.tx_upload)
    TextView txUpload;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_type)
    EditText etType;
    @BindView(R.id.et_address)
    EditText etAddress;
    @BindView(R.id.et_describe)
    EditText etDescribe;
    private CreateGroupWindow typeWindow = null;
    private CreateGroupWindow addressWindow = null;
    private List typeList = null;
    private List addressList = null;
    //头像
    private ArrayList<ImageItem> images = new ArrayList<>();
    private int IMAGE_PICKER = 1000;
    private String headUri = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        initView();
    }
    protected void initView() {
        setTitleText(getString(R.string.activity_create_public_title), View.VISIBLE);
        setTxTitleSecond(getString(R.string.activity_create_public_title_second));
        setPreviewText(getString(R.string.activity_create_public_submit), View.VISIBLE);
        GlideUtils.setImageId(this, R.drawable.shape_circle_head, imgHead, true);
    }

    @Override
    protected void preview() {
        super.preview();
    }

    @OnClick({R.id.img_head, R.id.et_type, R.id.et_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_head:
                PictureUtils.setHeadOperate(this);
                Intent intent = new Intent(this, ImageGridActivity.class);
                intent.putExtra(ImageGridActivity.EXTRAS_IMAGES, images);
                startActivityForResult(intent, IMAGE_PICKER);
                break;
            case R.id.et_type:
                if (typeList == null)
                    typeList = new ArrayList();
                else
                    typeList.clear();
                typeList.add("学习");
                typeList.add("美食");
                typeList.add("娱乐");
                typeList.add("旅游");
                typeList.add("旅游");
                typeList.add("旅游");
                typeList.add("旅游");
                typeList.add("旅游");
                if (typeWindow == null) {
                    typeWindow = new CreateGroupWindow(this);
                    typeWindow.initPopupWindow(this, etType, typeList);
                }
                typeWindow.setDataList(typeList);
                typeWindow.setTxTitle("选择分类");
                break;
            case R.id.et_address:
                if (addressList == null)
                    addressList = new ArrayList();
                else
                    addressList.clear();
                addressList.add("重庆");
                addressList.add("贵州");
                addressList.add("四川");
                addressList.add("云南");
                addressList.add("广州");
                addressList.add("海南");
                addressList.add("内蒙");
                addressList.add("西藏");
                if (addressWindow == null) {
                    addressWindow = new CreateGroupWindow(this);
                    addressWindow.initPopupWindow(this, etAddress, addressList);
                }
                addressWindow.setDataList(addressList);
                addressWindow.setTxTitle(" 选择地址");
                break;
        }
    }

    //提供给popupWindows修改首页背景色方法
    public void changeUiAlpha(Float alpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = alpha;
        getWindow().setAttributes(lp);
    }

    @Override
    public void onItemOnClick(View parent, int position) {
        if (parent == etType)
            etType.setText((CharSequence) typeList.get(position));
        if (parent == etAddress)
            etAddress.setText((CharSequence) addressList.get(position));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == IMAGE_PICKER) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                Glide.with(this)
                        .load(Uri.fromFile(new File(images.get(0).path)))
                        .apply(new RequestOptions().bitmapTransform(new CircleCrop()))
                        .into(imgHead);
                headUri = String.valueOf(images.get(0).path);
            } else {
                ToastUtils.showShort(this, "没有数据");
            }
        }
    }
}
