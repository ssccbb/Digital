package com.sung.digital.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sung.digital.R;
import com.sung.digital.common.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/4/24.
 */

public class ChildPager2Fragment extends BaseFragment {
    private static ChildPager2Fragment instance;
    private RecyclerView mList;
    private List mData = new ArrayList();

    public static ChildPager2Fragment newInstance(){
        if (instance != null){
            return instance;
        }
        return new ChildPager2Fragment();
    }

    public ChildPager2Fragment() {
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
        for (int i = 0; i < 10; i++) {
            mData.add(i);
        }
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        mList.setAdapter(new ListAdapter(mData));
        mList.setItemAnimator(new DefaultItemAnimator());
        mList.setHasFixedSize(true);
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
            return new ListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_item,null,false));
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
