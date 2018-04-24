package com.sung.digital.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sung.digital.R;
import com.sung.digital.common.BaseActivity;
import com.sung.digital.widget.TabIndicatorView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener {
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
        mToolBar = findViewById(R.id.tool_bar);
        mViewPager = findViewById(R.id.view_pager);
        mIndicator = findViewById(R.id.tab_indicator);

        /***Toolbar*/
        mToolBar.setTitle(R.string.app_name);
        setSupportActionBar(mToolBar);
        mToolBar.setOnMenuItemClickListener(this);
        /***TabLayout*/
        mTabLayout.setVisibility(View.VISIBLE);
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB 1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB 2"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB 3"));
        mTabLayout.setupWithViewPager(mViewPager);
        /***ViewPager*/
    }

    @Override
    public void initData() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    class ListAdapter extends RecyclerView.Adapter {
        private List data = new ArrayList();

        public ListAdapter(List data) {
            if (data != null){
                this.data = data;
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,null,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ListHolder)holder).onBind(position);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class ListHolder extends RecyclerView.ViewHolder {
            private TextView text;

            public ListHolder(View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.text);
            }

            void onBind(int position){
                text.setText(String.valueOf(data.get(position)));
            }
        }
    }
}
