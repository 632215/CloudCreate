package com.weis.cloudcreate.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
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
import com.weis.cloudcreate.utils.StringUtils;
import com.weis.cloudcreate.utils.ToastUtils;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/7/30.
 */

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.img_head)
    ImageView imgHead;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_mail)
    EditText etMail;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.tx_has)
    TextView txHas;
    @BindView(R.id.tx_self)
    TextView txSelf;
    @BindView(R.id.tx_rule)
    TextView txRule;

    private ArrayList<ImageItem> images = new ArrayList<>();
    private int IMAGE_PICKER = 1000;
    private String headUri = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    protected void initView() {
        showBackView();
        GlideUtils.setImageId(this, R.drawable.shape_circle_head, imgHead, true);
    }

    @OnClick({R.id.img_head
            , R.id.img_register
            , R.id.tx_has
            , R.id.tx_self
            , R.id.tx_rule})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_head:
                PictureUtils.setHeadOperate(this);
                Intent intent = new Intent(this, ImageGridActivity.class);
                intent.putExtra(ImageGridActivity.EXTRAS_IMAGES, images);
                startActivityForResult(intent, IMAGE_PICKER);
                break;

            case R.id.img_register:
                checkInput();
                break;

            case R.id.tx_has:
                startActivity(new Intent(this, LoginActivity.class));
                break;

            case R.id.tx_self:
                startActivity(new Intent(this, BaseWebActivity.class)
                        .putExtra("url", "https://www.baidu.com")
                        .putExtra("title", getString(R.string.activity_register_self)));
                break;

            case R.id.tx_rule:
                startActivity(new Intent(this, BaseWebActivity.class)
                        .putExtra("url", "https://www.baidu.com")
                        .putExtra("title", getString(R.string.activity_register_rule)));
                break;
        }
    }

    private void checkInput() {
        if (StringUtils.isEmpty(etName.getText().toString().trim())) {
            ToastUtils.showLong(this, getString(R.string.activity_register_input_name));
            return;
        }
        if (StringUtils.isEmpty(etMail.getText().toString().trim())) {
            ToastUtils.showLong(this, getString(R.string.activity_register_input_mail));
            return;
        }
        if (StringUtils.isEmpty(etPwd.getText().toString().trim())) {
            ToastUtils.showLong(this, getString(R.string.activity_register_input_pwd));
            return;
        }

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
