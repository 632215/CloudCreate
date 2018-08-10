package com.weis.cloudcreate.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/10.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentList;
    private ArrayList<String> titleList;

    public FragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList, ArrayList<String> titleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    //显示标签上的文字
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
