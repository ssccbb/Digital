package com.sung.digital.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sung.digital.ui.fragment.child.GroupNewestPagerFragment;
import com.sung.digital.ui.fragment.child.GroupHotestPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/4/24.
 */

public class GroupChildPagerAdapter extends FragmentPagerAdapter {
    private FragmentManager manager;
    private List<Fragment> fragments = new ArrayList();

    private Context context;

    public GroupChildPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initFragments();
    }

    private void initFragments(){
        if (fragments == null) fragments = new ArrayList();
        GroupNewestPagerFragment fragment1 = GroupNewestPagerFragment.newInstance();
        GroupHotestPagerFragment fragment2 = GroupHotestPagerFragment.newInstance();
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
