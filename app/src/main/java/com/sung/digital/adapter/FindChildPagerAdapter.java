package com.sung.digital.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sung.digital.ui.fragment.child.FindCommunicatePagerFragment;
import com.sung.digital.ui.fragment.child.FindNewsPagerFragment;
import com.sung.digital.ui.fragment.child.FindPicPagerFragment;
import com.sung.digital.ui.fragment.child.FindSellPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/4/24.
 */

public class FindChildPagerAdapter extends FragmentPagerAdapter {
    private FragmentManager manager;
    private List<Fragment> fragments = new ArrayList();

    private Context context;

    public FindChildPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initFragments();
    }

    private void initFragments(){
        if (fragments == null) fragments = new ArrayList();
        FindPicPagerFragment fragment1 = FindPicPagerFragment.newInstance();
        FindNewsPagerFragment fragment2 = FindNewsPagerFragment.newInstance();
        FindCommunicatePagerFragment fragment3 = FindCommunicatePagerFragment.newInstance();
        FindSellPagerFragment fragment4 = FindSellPagerFragment.newInstance();
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
