package com.sung.digital.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sung.digital.R;
import com.sung.digital.adapter.HomePagerAdapter;
import com.sung.digital.common.BaseActivity;
import com.sung.digital.common.Constants;
import com.sung.digital.widget.TabIndicatorView;

public class HomeActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener,
        ViewPager.OnPageChangeListener, TabIndicatorView.OnTabIndicatorSelectListener, View.OnClickListener{
    private AppBarLayout mAppBar;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolBar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private HomePagerAdapter mHomeAdapter;
    private TabIndicatorView mIndicator;

    @Override
    public int initLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mTabLayout = findViewById(R.id.tab_layout);
        mAppBar = findViewById(R.id.app_bar_layout);
        mToolBar = findViewById(R.id.tool_bar);
        mViewPager = findViewById(R.id.view_pager);
        mIndicator = findViewById(R.id.tab_indicator);
    }

    @Override
    public void initData() {
        /***Toolbar*/
        mToolBar.setTitle(R.string.app_name);
        mToolBar.setNavigationIcon(R.mipmap.ic_menu_list);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawerLayout();
            }
        });
        mToolBar.setOnMenuItemClickListener(this);
        /***ViewPager*/
        mHomeAdapter = new HomePagerAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mHomeAdapter);
        mViewPager.setOffscreenPageLimit(0);
        mViewPager.addOnPageChangeListener(this);
        /***Indicator*/
        mIndicator.addOnTabIndicatorSelectListener(this);
        /***DrawerLayout*/
        closeDrawerLayout();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        mIndicator.select(position);
        mToolBar.setTitle(position == 0 ?
                getResources().getString(R.string.app_name ) : Constants.home_indicator_tag[position]);

        //tablayout
        switch (position){
            case 0:
            case 3:
                mTabLayout.setVisibility(View.GONE);
                break;
            case 1:
            case 2:
                mTabLayout.setVisibility(View.VISIBLE);
                resetTab(position);
                break;

        }
    }

    private void resetTab(int position){
        if (mTabLayout != null){
            mTabLayout.removeAllTabs();
            mTabLayout.clearOnTabSelectedListeners();
            mTabLayout.setupWithViewPager(null);
            mHomeAdapter.getItem(position).bindViewPager(mTabLayout);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tool_bar,menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                break;
            case R.id.action_add:
                break;
        }
        return false;
    }

    @Override
    public void onTabSelect(int position) {
        mViewPager.setCurrentItem(position, true);
    }

    private void openDrawerLayout(){
        mDrawerLayout.openDrawer(Gravity.LEFT);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
                Gravity.LEFT);
    }

    private void closeDrawerLayout(){
        mDrawerLayout.closeDrawer(Gravity.LEFT);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
                Gravity.LEFT);
    }

    @Override
    public void onClick(View v) {
    }
}
