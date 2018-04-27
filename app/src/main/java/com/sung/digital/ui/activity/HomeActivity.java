package com.sung.digital.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sung.digital.R;
import com.sung.digital.adapter.HomePagerAdapter;
import com.sung.digital.common.BaseActivity;
import com.sung.digital.widget.TabIndicatorView;

public class HomeActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener,
        ViewPager.OnPageChangeListener, TabIndicatorView.OnTabIndicatorSelectListener, View.OnClickListener{
    private AppBarLayout mAppBar;
    private Toolbar mToolBar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TabIndicatorView mIndicator;

    @Override
    public int initLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        mTabLayout = findViewById(R.id.tab_layout);
        mAppBar = findViewById(R.id.app_bar_layout);
        mToolBar = findViewById(R.id.tool_bar);
        mViewPager = findViewById(R.id.view_pager);
        mIndicator = findViewById(R.id.tab_indicator);

        /***Toolbar*/
        mToolBar.setTitle(R.string.app_name);
        mToolBar.setNavigationIcon(R.mipmap.ic_menu_list);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastShort("menu");
            }
        });
        mToolBar.setOnMenuItemClickListener(this);
        /***TabLayout*/
//        mTabLayout.setVisibility(View.VISIBLE);
//        mTabLayout.addTab(mTabLayout.newTab().setText("TAB 1"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("TAB 2"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("TAB 3"));
//        mTabLayout.setupWithViewPager(mViewPager);
        /***ViewPager*/
        HomePagerAdapter adapter =
                new HomePagerAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(0);
        mViewPager.addOnPageChangeListener(this);
        /***Indicator*/
        mIndicator.addOnTabIndicatorSelectListener(this);
    }

    @Override
    public void initData() {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        mIndicator.select(position);
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

    @Override
    public void onClick(View v) {
    }
}
