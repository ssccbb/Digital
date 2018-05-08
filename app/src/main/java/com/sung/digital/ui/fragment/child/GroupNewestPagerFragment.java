package com.sung.digital.ui.fragment.child;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sung.digital.R;
import com.sung.digital.adapter.HomeMultiLayoutAdapter;
import com.sung.digital.adapter.RecyclerDecoration;
import com.sung.digital.bean.MultiListItemModel;
import com.sung.digital.common.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/4/24.
 */

public class GroupNewestPagerFragment extends BaseFragment {
    private static GroupNewestPagerFragment instance;
    private RecyclerView mList;
    private List mData = new ArrayList();

    public static GroupNewestPagerFragment newInstance(){
        if (instance != null){
            return instance;
        }
        return new GroupNewestPagerFragment();
    }

    public GroupNewestPagerFragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_pager;
    }

    @Override
    public void initView() {
        mList = findView(R.id.list);
    }

    @Override
    public void setData() {
        if (mData != null) mData.clear();
        for (int i = 0; i < 20; i++) {
            mData.add(new MultiListItemModel());
        }
        mList.setAdapter(new HomeMultiLayoutAdapter(getContext(),mData,false,false));
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        mList.addItemDecoration(new RecyclerDecoration(
                getContext(),R.color.colorDivider,R.dimen.common_divider_larger_height));
        mList.setItemAnimator(new DefaultItemAnimator());
        mList.setHasFixedSize(true);
    }

}
