package com.sung.digital.adapter;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sung.digital.R;
import com.sung.digital.bean.GroupMultiListItemModel;
import com.sung.digital.bean.GroupMultiListItemModel;
import com.sung.digital.common.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/5/16.
 */

public class GroupMultiLayoutAdapter extends RecyclerView.Adapter {
    private static String TAG = GroupMultiLayoutAdapter.class.getSimpleName();
    private List<GroupMultiListItemModel> mData = new ArrayList();
    private Context mContext;
    private boolean mHasHead = true;

    public GroupMultiLayoutAdapter(List<GroupMultiListItemModel> mData, Context mContext, boolean hasHead) {
        this.mData = mData;
        this.mContext = mContext;
        this.mHasHead = hasHead;
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
            multiItemHolder.onBind(mHasHead ? (position - 1) : position);
        }
    }

    @Override
    public int getItemCount() {
        return mHasHead ? (mData.size() + 1) : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && mHasHead){
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
        private RecyclerView headList;

        public HeadHolder(View itemView) {
            super(itemView);
            headList = itemView.findViewById(R.id.rc_list);
        }

        void onBind(){
            LinearLayoutManager manager = new LinearLayoutManager(mContext);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            headList.setLayoutManager(manager);
            headList.setAdapter(new HeadListAdapter(mData));
            headList.addItemDecoration(new RecyclerDecoration(
                    mContext,android.R.color.transparent,R.dimen.common_divider_larger_height,true));
            headList.setItemAnimator(new DefaultItemAnimator());
            headList.setHasFixedSize(true);
        }

        @Override
        public void onClick(View v) {

        }

        class HeadListAdapter extends RecyclerView.Adapter {
            private List data = new ArrayList();

            public HeadListAdapter(List data) {
                this.data = data;
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                ImageView view = new ImageView(parent.getContext());
                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
                view.setLayoutParams(new ViewGroup.LayoutParams(
                        500, ViewGroup.LayoutParams.MATCH_PARENT));
                return new HeadListHolder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                if (holder instanceof HeadListHolder){
                    ((HeadListHolder) holder).onBind(position);
                }
            }

            @Override
            public int getItemCount() {
                return data.size();
            }

            class HeadListHolder extends RecyclerView.ViewHolder {
                private ImageView rootView;

                public HeadListHolder(View itemView) {
                    super(itemView);
                    rootView = (ImageView) itemView;
                }

                void onBind(int position){
                    rootView.setImageResource(R.color.colorPrimary);
                }
            }
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
            GroupMultiListItemModel data = mData.get(position);
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
