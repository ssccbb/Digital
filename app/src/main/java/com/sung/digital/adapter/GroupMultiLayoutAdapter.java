package com.sung.digital.adapter;

import android.content.Context;
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
 * Created by sung on 2018/5/16.
 */

public class GroupMultiLayoutAdapter extends RecyclerView.Adapter {
    private static String TAG = GroupMultiLayoutAdapter.class.getSimpleName();
    private List<MultiListItemModel> mData = new ArrayList();
    private Context mContext;

    public GroupMultiLayoutAdapter(List<MultiListItemModel> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == Constants.GROUP_HEAD_ITEM){
            view = inflater.inflate(R.layout.view_group_item_head,parent,false);
            view.setTag(Constants.GROUP_HEAD_ITEM);
            return new HeadHolder(view);
        }
        if (viewType == Constants.GROUP_MAJOR_PIC){
            view = inflater.inflate(R.layout.view_group_item_major_pic, parent, false);
            view.setTag(Constants.GROUP_MAJOR_PIC);
        }
        if (viewType == Constants.GROUP_DOUBLE_PIC){
            view = inflater.inflate(R.layout.view_group_item_double_pic, parent, false);
            view.setTag(Constants.GROUP_DOUBLE_PIC);
        }
        if (viewType == Constants.GROUP_NINE_PIC){
            view = inflater.inflate(R.layout.view_group_item_nine_pic, parent, false);
            view.setTag(Constants.GROUP_NINE_PIC);
        }
        if (view == null) {
            view = inflater.inflate(R.layout.view_group_item_major_text, parent, false);
            view.setTag(Constants.GROUP_MAJOR_TEXT);
        }
        return new MultiItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeadHolder){
            HeadHolder headHolder = (HeadHolder) holder;
            headHolder.onBind();
        }
        if (holder instanceof MultiItemHolder){
            MultiItemHolder multiItemHolder = (MultiItemHolder) holder;
            multiItemHolder.onBind(position - 1);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return Constants.GROUP_HEAD_ITEM;
        }
        if (mData != null && !mData.isEmpty() && mData.size() > position){
            return mData.get(position).mode;
        }
        return Constants.GROUP_MAJOR_TEXT;
    }

    /**
     * 头有自己的逻辑
     * */
    class HeadHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public HeadHolder(View itemView) {
            super(itemView);
        }

        void onBind(){

        }

        @Override
        public void onClick(View v) {

        }
    }

    /**
     * 正常item
     * */
    class MultiItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private int mode = -1;

        public MultiItemHolder(View itemView) {
            super(itemView);
            if (itemView.getTag() == null) return;

            mode = (int) itemView.getTag();
            if (mode == Constants.GROUP_MAJOR_TEXT){

            }
            if (mode == Constants.GROUP_MAJOR_PIC){

            }
            if (mode == Constants.GROUP_DOUBLE_PIC){

            }
            if (mode == Constants.GROUP_NINE_PIC){

            }
        }

        void onBind(int position){
            MultiListItemModel data = mData.get(position);
            if (mode == -1) return;//头不管

            itemView.setOnClickListener(this);
            if (mode == Constants.GROUP_MAJOR_TEXT){

            }
            if (mode == Constants.GROUP_MAJOR_PIC){

            }
            if (mode == Constants.GROUP_DOUBLE_PIC){

            }
            if (mode == Constants.GROUP_NINE_PIC){

            }
        }

        @Override
        public void onClick(View v) {

        }
    }
}
