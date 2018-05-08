package com.sung.digital.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.sung.digital.R;
import com.sung.digital.adapter.GroupChildPagerAdapter;
import com.sung.digital.common.BaseFragment;

/**
 * Created by sung on 2018/4/24.
 */

public class GroupPagerFragment extends BaseFragment implements ViewPager.OnPageChangeListener,TabLayout.OnTabSelectedListener{
    private static GroupPagerFragment instance;
    private ViewPager mPager;
    private TabLayout mTab;

    public static GroupPagerFragment newInstance(){
        if (instance != null){
            return instance;
        }
        return new GroupPagerFragment();
    }

    public GroupPagerFragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_group_pager;
    }

    @Override
    public void initView() {
        mPager = findView(R.id.view_pager);
    }

    @Override
    public void setData() {
        GroupChildPagerAdapter adapter =
                new GroupChildPagerAdapter(getContext(), getChildFragmentManager());
        mPager.setAdapter(adapter);
        mPager.setOffscreenPageLimit(0);
        mPager.addOnPageChangeListener(this);
    }

    @Override
    public void bindViewPager(TabLayout tabLayout) {
        if (tabLayout == null) return;
        this.mTab = tabLayout;
        mTab.setupWithViewPager(mPager);
        mTab.removeAllTabs();
        mTab.addTab(mTab.newTab().setText("最新"));
        mTab.addTab(mTab.newTab().setText("热门"));
        mTab.addOnTabSelectedListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (mTab != null && mTab.getTabAt(position) != null) {
            mTab.getTabAt(position).select();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (mPager != null) {
            mPager.setCurrentItem(tab.getPosition(),true);
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
