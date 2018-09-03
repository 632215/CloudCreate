package com.weis.cloudcreate.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.weis.cloudcreate.R;
import com.weis.cloudcreate.view.adapter.FragmentAdapter;
import com.weis.cloudcreate.view.fragment.AddGroupFragment;
import com.weis.cloudcreate.view.fragment.AddHumanFragment;
import com.weis.cloudcreate.view.fragment.AddPublicFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/8/5.
 */

public class AddActivity extends BaseActivity {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_page)
    ViewPager viewPage;

    private ArrayList<Fragment> fragmentList;
    private ArrayList<String> titleList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
    }

    protected void initView() {
        setTitleText(getString(R.string.activity_add_title), View.VISIBLE);
        initData();
        initTab();
        viewPage.setCurrentItem(getIntent().getIntExtra("index",0));
    }

    private void initData() {
        fragmentList = new ArrayList();
        titleList = new ArrayList();
        fragmentList.add(new AddHumanFragment());
        fragmentList.add(new AddGroupFragment());
        fragmentList.add(new AddPublicFragment());
        titleList.add(getString(R.string.activity_add_human));
        titleList.add(getString(R.string.activity_add_group));
        titleList.add(getString(R.string.activity_add_public));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        viewPage.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragmentList, titleList));
        tabLayout.setupWithViewPager(viewPage);
    }

    private void initTab() {
        for (int x = 0; x < tabLayout.getTabCount(); x++)
            setIcon(x, titleList.get(x));
    }

    //设置TabItem
    private void setIcon(int position, String title) {
        TabLayout.Tab tab = tabLayout.getTabAt(position);
        tab.setCustomView(R.layout.item_tab_item);
        ViewHolder holder = new ViewHolder(tab.getCustomView());
        holder.txTitle.setText(title);
        holder.txTitle.setTextSize(14f);
    }

    class ViewHolder {
        TextView txTitle;

        public ViewHolder(View tabView) {
            txTitle = tabView.findViewById(R.id.tx_title);
        }
    }
}
