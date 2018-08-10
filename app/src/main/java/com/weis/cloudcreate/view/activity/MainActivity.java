package com.weis.cloudcreate.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.presenter.BasePresenter;
import com.weis.cloudcreate.view.custom.AddPopupWindow;
import com.weis.cloudcreate.view.custom.CustomRadioButton;
import com.weis.cloudcreate.view.fragment.CarFragment;
import com.weis.cloudcreate.view.fragment.CommunicationFragment;
import com.weis.cloudcreate.view.fragment.HumanFragment;
import com.weis.cloudcreate.view.fragment.MsgFragment;
import com.weis.cloudcreate.view.fragment.MyFragment;
import com.weis.cloudcreate.view.fragment.SaleFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;

    @BindView(R.id.rb_sale)
    CustomRadioButton rbSale;
    @BindView(R.id.rb_car)
    CustomRadioButton rbCar;
    @BindView(R.id.rb_human)
    CustomRadioButton rbHuman;
    @BindView(R.id.rb_msg)
    CustomRadioButton rbMsg;
    @BindView(R.id.rb_communication)
    CustomRadioButton rbCommunication;
    @BindView(R.id.rb_my)
    CustomRadioButton rbMy;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    @BindView(R.id.rl_main)
    RelativeLayout rlMain;
    @BindView(R.id.tx_main_left)
    TextView txMainLeft;
    @BindView(R.id.img_add)
    ImageView imgAdd;
    @BindView(R.id.img_search)
    ImageView imgSearch;
    @BindView(R.id.img_online)
    ImageView imgOnline;
    @BindView(R.id.img_more)
    ImageView imgMore;
    @BindView(R.id.tx_platform)
    TextView txPlatform;
    @BindView(R.id.tx_government)
    TextView txGovernment;
    @BindView(R.id.tx_stock)
    TextView txStock;
    @BindView(R.id.tx_game)
    TextView txGame;
    @BindView(R.id.textView2)
    TextView textView2;

    private FragmentTransaction transaction;
    private FragmentManager manager;
    private SaleFragment saleFragment;
    private CarFragment carFragment;
    private HumanFragment humanFragment;
    private MsgFragment msgFragment;
    private CommunicationFragment communicationFragment;
    private MyFragment myFragment;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter setPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        setTitleText(getString(R.string.activity_main_title), View.GONE);
        setDefaultFragment();
        addDrawerListener();
    }

    //监听侧边栏事件
    private void addDrawerListener() {
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // TODO: 2018/8/3 待开发
            }
        });
    }

    public void setDefaultFragment() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        rgMain.setOnCheckedChangeListener(this);
        if (msgFragment == null)
            msgFragment = new MsgFragment();
        transaction.add(R.id.fl_content, msgFragment);
        transaction.commit();
        rgMain.check(R.id.rb_msg);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        switch (i) {
            case R.id.rb_sale: //热卖
                if (saleFragment == null)
                    saleFragment = new SaleFragment();
                transaction.replace(R.id.fl_content, saleFragment);
                rbCar.setNum(67);
                break;

            case R.id.rb_car: //购物车
                if (carFragment == null)
                    carFragment = new CarFragment();
                transaction.replace(R.id.fl_content, carFragment);
                rbCar.setNum(2);
                break;

            case R.id.rb_human://人脉
                if (humanFragment == null)
                    humanFragment = new HumanFragment();
                transaction.replace(R.id.fl_content, humanFragment);
                rbCar.setNum(100);
                break;

            case R.id.rb_msg: //消息
                if (msgFragment == null)
                    msgFragment = new MsgFragment();
                transaction.replace(R.id.fl_content, msgFragment);
                rbCar.setNum(0);
                break;

            case R.id.rb_communication: //通讯录
                if (communicationFragment == null)
                    communicationFragment = new CommunicationFragment();
                transaction.replace(R.id.fl_content, communicationFragment);
                break;

            case R.id.rb_my: //我的
                if (myFragment == null)
                    myFragment = new MyFragment();
                transaction.replace(R.id.fl_content, myFragment);
                break;
        }
        transaction.commit();
    }

    @OnClick({R.id.tx_main_left
            , R.id.img_add
            , R.id.img_search
            , R.id.img_online
            , R.id.img_more
            , R.id.tx_game
            , R.id.tx_stock
            , R.id.tx_government
            , R.id.tx_platform})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tx_main_left:
                controlMainLeft(1);
                break;
            case R.id.img_add:
                AddPopupWindow addPopupWindow = new AddPopupWindow();
                addPopupWindow.initPopupWindow(this, imgAdd);
                break;

            case R.id.img_search:
                break;

            case R.id.img_online:
                break;

            case R.id.tx_game:
                break;

            case R.id.tx_stock:
                break;

            case R.id.tx_government:
                break;

            case R.id.tx_platform:
                break;
        }
    }

    //控制侧边栏
    private void controlMainLeft(int i) {//0 关闭  1开启
        switch (i) {
            case 0:
                if (drawerLayout.isDrawerOpen(Gravity.START))
                    drawerLayout.closeDrawer(Gravity.START);
                break;

            case 1:
                if (!drawerLayout.isDrawerOpen(Gravity.START))
                    drawerLayout.openDrawer(Gravity.START);
                break;
        }
    }

    //提供给popupWindows修改首页背景色方法
    public void changeUiAlpha(Float alpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = alpha;
        getWindow().setAttributes(lp);
    }
}
