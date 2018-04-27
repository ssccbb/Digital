package com.sung.digital.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sung.digital.ui.fragment.ChildPager1Fragment;
import com.sung.digital.ui.fragment.ChildPager2Fragment;
import com.sung.digital.ui.fragment.HomePager1Fragment;
import com.sung.digital.ui.fragment.HomePager2Fragment;
import com.sung.digital.ui.fragment.HomePager3Fragment;
import com.sung.digital.ui.fragment.HomePager4Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/4/24.
 */

public class ChildPagerAdapter extends FragmentPagerAdapter {
    private FragmentManager manager;
    private List<Fragment> fragments = new ArrayList();

    private Context context;

    public ChildPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initFragments();
    }

    private void initFragments(){
        if (fragments == null) fragments = new ArrayList();
        ChildPager1Fragment fragment1 = ChildPager1Fragment.newInstance();
        ChildPager2Fragment fragment2 = ChildPager2Fragment.newInstance();
        fragments.add(fragment1);
        fragments.add(fragment2);
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
