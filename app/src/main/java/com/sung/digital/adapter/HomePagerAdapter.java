package com.sung.digital.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sung.digital.ui.fragment.HomePager1Fragment;
import com.sung.digital.ui.fragment.HomePager2Fragment;
import com.sung.digital.ui.fragment.HomePager3Fragment;
import com.sung.digital.ui.fragment.HomePager4Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/4/24.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {
    private FragmentManager manager;
    private List<Fragment> fragments = new ArrayList();

    private Context context;

    public HomePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initFragments();
    }

    private void initFragments(){
        if (fragments == null) fragments = new ArrayList();
        HomePager1Fragment fragment1 = HomePager1Fragment.newInstance();
        HomePager2Fragment fragment2 = HomePager2Fragment.newInstance();
        HomePager3Fragment fragment3 = HomePager3Fragment.newInstance();
        HomePager4Fragment fragment4 = HomePager4Fragment.newInstance();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
