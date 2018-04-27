package com.sung.digital.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.sung.digital.R;
import com.sung.digital.adapter.ChildPagerAdapter;
import com.sung.digital.adapter.HomePagerAdapter;
import com.sung.digital.common.BaseFragment;

/**
 * Created by sung on 2018/4/24.
 */

public class HomePager2Fragment extends BaseFragment implements ViewPager.OnPageChangeListener,TabLayout.OnTabSelectedListener{
    private ViewPager mPager;
    private TabLayout mTab;

    public static HomePager2Fragment newInstance(){
        return new HomePager2Fragment();
    }

    public HomePager2Fragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_pager_2;
    }

    @Override
    public void initView() {
        mPager = findView(R.id.view_pager);
    }

    @Override
    public void setData() {
        ChildPagerAdapter adapter =
                new ChildPagerAdapter(getContext(), getChildFragmentManager());
        mPager.setAdapter(adapter);
        mPager.setOffscreenPageLimit(0);
        mPager.addOnPageChangeListener(this);
    }

    @Override
    public void bindViewPager(TabLayout tabLayout) {
        if (tabLayout == null) return;
        this.mTab = tabLayout;
        mTab.setupWithViewPager(mPager);
        mTab.addOnTabSelectedListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (mTab != null) mTab.getTabAt(position).select();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mPager.setCurrentItem(tab.getPosition(),true);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
