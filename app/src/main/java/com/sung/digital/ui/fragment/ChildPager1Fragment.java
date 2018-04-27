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

public class ChildPager1Fragment extends BaseFragment {
    private RecyclerView mList;
    private List mData = new ArrayList();

    public static ChildPager1Fragment newInstance(){
        return new ChildPager1Fragment();
    }

    public ChildPager1Fragment() {
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
        for (int i = 0; i < 100; i++) {
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
