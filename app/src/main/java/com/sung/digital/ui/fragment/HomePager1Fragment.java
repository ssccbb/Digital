package com.sung.digital.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.sung.digital.R;
import com.sung.digital.adapter.IndexListAdapter;
import com.sung.digital.common.BaseFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/4/24.
 */

public class HomePager1Fragment extends BaseFragment {
    private static HomePager1Fragment instance;
    private RecyclerView mList;
    private List mData = new ArrayList();

    public static HomePager1Fragment newInstance(){
        if (instance != null){
            return instance;
        }
        return instance = new HomePager1Fragment();
    }

    public HomePager1Fragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_pager_1;
    }

    @Override
    public void initView() {
        mList = findView(R.id.list);
    }

    @Override
    public void setData() {
        if (mData != null) mData.clear();
        for (int i = 0; i < 20; i++) {
            mData.add(i);
        }
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        mList.setAdapter(new IndexListAdapter(getContext(), mData));
        mList.setItemAnimator(new DefaultItemAnimator());
        mList.setHasFixedSize(true);
    }

}
