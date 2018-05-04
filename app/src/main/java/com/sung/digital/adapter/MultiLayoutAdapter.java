package com.sung.digital.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sung.digital.R;
import com.sung.digital.bean.MultiListItemModel;
import com.sung.digital.common.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/5/4.
 *
 * 多布局adapter
 */

public class MultiLayoutAdapter extends RecyclerView.Adapter {
    private static String TAG = MultiLayoutAdapter.class.getSimpleName();
    private List<MultiListItemModel> mData = new ArrayList();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == Constants.LIST_MAJOR_TEXT_MODE){
            view = inflater.inflate(R.layout.view_index_item_major_text, null, false);
            view.setTag(Constants.LIST_MAJOR_TEXT_MODE);
        }
        if (viewType == Constants.LIST_MULTI_PIC_MODE){
            view = inflater.inflate(R.layout.view_index_item_major_pic, null, false);
            view.setTag(Constants.LIST_MAJOR_TEXT_MODE);
        }
        if (view == null) {
            view = inflater.inflate(R.layout.view_index_item_multi_pic, null, false);
            view.setTag(Constants.LIST_MULTI_PIC_MODE);
        }
        return new MultiItemHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (mData != null && !mData.isEmpty() && mData.size() > position){
            return mData.get(position).mode;
        }
        return Constants.LIST_MAJOR_PIC_MODE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MultiItemHolder){
            MultiItemHolder multiItemHolder = (MultiItemHolder) holder;
            multiItemHolder.onBind(position);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MultiItemHolder extends RecyclerView.ViewHolder {
        private int mode = -1;

        public MultiItemHolder(View itemView) {
            super(itemView);
            if (itemView.getTag() == null) return;

            mode = (int) itemView.getTag();
            if (mode == Constants.LIST_MAJOR_PIC_MODE){

            }

            if (mode == Constants.LIST_MAJOR_TEXT_MODE){

            }

            if (mode == Constants.LIST_MULTI_PIC_MODE){

            }
        }

        void onBind(int position){
            MultiListItemModel data = mData.get(position);
            if (mode == -1) return;

            if (mode == Constants.LIST_MAJOR_PIC_MODE){

            }

            if (mode == Constants.LIST_MAJOR_TEXT_MODE){

            }

            if (mode == Constants.LIST_MULTI_PIC_MODE){

            }
        }
    }
}
