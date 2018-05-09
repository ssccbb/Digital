package com.sung.digital.ui.fragment.child;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sung.digital.R;
import com.sung.digital.adapter.FindWaterFallAdapter;
import com.sung.digital.adapter.RecyclerDecoration;
import com.sung.digital.bean.FindPicModel;
import com.sung.digital.common.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/4/24.
 */

public class FindPicPagerFragment extends BaseFragment {
    private static FindPicPagerFragment instance;
    private RecyclerView mList;
    private List<FindPicModel> mData = new ArrayList();

    public static FindPicPagerFragment newInstance(){
        if (instance != null){
            return instance;
        }
        return new FindPicPagerFragment();
    }

    public FindPicPagerFragment() {
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
        for (int i = 0; i < 31; i++) {
            mData.add(new FindPicModel());
        }
        mList.setLayoutManager(new StaggeredGridLayoutManager(
                2,StaggeredGridLayoutManager.VERTICAL));
        mList.setAdapter(new FindWaterFallAdapter(getContext(),mData));
        mList.setItemAnimator(new DefaultItemAnimator());
        mList.addItemDecoration(new RecyclerDecoration(
                getContext(),
                android.R.color.transparent,
                R.dimen.dp_10,
                true));
        mList.setHasFixedSize(true);
    }
}
