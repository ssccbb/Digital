package com.sung.digital.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sung.digital.common.BaseFragment;
import com.sung.digital.ui.fragment.HomePagerFragment;
import com.sung.digital.ui.fragment.GroupPagerFragment;
import com.sung.digital.ui.fragment.FindPagerFragment;
import com.sung.digital.ui.fragment.NoticePagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/4/24.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {
    private FragmentManager manager;
    private List<BaseFragment> fragments = new ArrayList();

    private Context context;

    public HomePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initFragments();
    }

    private void initFragments(){
        if (fragments == null) fragments = new ArrayList();
        HomePagerFragment fragment1 = HomePagerFragment.newInstance();
        GroupPagerFragment fragment2 = GroupPagerFragment.newInstance();
        FindPagerFragment fragment3 = FindPagerFragment.newInstance();
        NoticePagerFragment fragment4 = NoticePagerFragment.newInstance();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);
    }

    @Override
    public BaseFragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
