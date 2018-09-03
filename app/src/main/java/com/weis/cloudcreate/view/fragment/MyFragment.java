package com.weis.cloudcreate.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.utils.GlideUtils;
import com.weis.cloudcreate.view.activity.MyPackageActivity;
import com.weis.cloudcreate.view.activity.SettingActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/8/3.
 */

public class MyFragment extends BaseFragment {
    @BindView(R.id.img_head)
    ImageView imgHead;
    @BindView(R.id.tx_name)
    TextView txName;
    @BindView(R.id.tx_account)
    TextView txAccount;
    @BindView(R.id.img_qrcode)
    ImageView imgQrcode;
    @BindView(R.id.tx_set)
    TextView txSet;
    @BindView(R.id.tx_collection)
    TextView txCollection;
    @BindView(R.id.tx_mail)
    TextView txMail;
    @BindView(R.id.tx_package)
    TextView txPackage;
    @BindView(R.id.tx_album)
    TextView txAlbum;

    @Override
    protected int getContentView() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        GlideUtils.setImageId(getContext(), R.mipmap.ic_launcher_round, imgHead, true);
        txName.setText("Lisa");
        txAccount.setText(getContext().getString(R.string.activity_person_info_account) + "13125263");
    }

    @OnClick({R.id.img_qrcode
            , R.id.tx_set
            , R.id.tx_collection
            , R.id.tx_mail
            , R.id.tx_package
            , R.id.tx_album})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_qrcode:
                break;

            case R.id.tx_set:
                startActivity(new Intent(getContext(), SettingActivity.class));
                break;

            case R.id.tx_collection:
                break;

            case R.id.tx_mail:
                break;

            case R.id.tx_package:
                startActivity(new Intent(getContext(), MyPackageActivity.class));
                break;

            case R.id.tx_album:
                break;
        }
    }
}
