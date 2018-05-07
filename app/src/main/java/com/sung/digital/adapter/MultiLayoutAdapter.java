package com.sung.digital.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sung.digital.R;
import com.sung.digital.bean.MultiListItemModel;
import com.sung.digital.common.Constants;
import com.sung.digital.widget.banner.AutoScrollViewPager;
import com.sung.digital.widget.banner.ScaleTransformer;

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
    private boolean hasBanner = false;
    private Context mContext;

    public MultiLayoutAdapter(Context context,List<MultiListItemModel> mData, boolean hasBanner) {
        this.mData = mData;
        this.hasBanner = hasBanner;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == Constants.LIST_BANNER_MODE){
            view = inflater.inflate(R.layout.view_banner,null,false);
            view.setTag(Constants.LIST_BANNER_MODE);
            return new BannerItemHolder(view);
        }
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
        if (hasBanner && position == 0){
            return Constants.LIST_BANNER_MODE;
        }
        if (mData != null && !mData.isEmpty() && mData.size() > position){
            return mData.get(position).mode;
        }
        return Constants.LIST_MAJOR_PIC_MODE;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MultiItemHolder){
            MultiItemHolder multiItemHolder = (MultiItemHolder) holder;
            multiItemHolder.onBind(hasBanner ? position - 1 : position);
        }
        if (holder instanceof BannerItemHolder){
            BannerItemHolder bannerItemHolder = (BannerItemHolder) holder;
            bannerItemHolder.onBind();
        }
    }

    @Override
    public int getItemCount() {
        if (hasBanner){
            return mData.size() + 1;
        }
        return mData.size();
    }

    class BannerItemHolder extends RecyclerView.ViewHolder {
        private AutoScrollViewPager autoViewPager;
        private TextView autoTittleText;

        public BannerItemHolder(View itemView) {
            super(itemView);
            autoViewPager = itemView.findViewById(R.id.auto_scroll_view_pager);
            autoTittleText = itemView.findViewById(R.id.auto_scroll_pager_tittle);
        }

        void onBind(){
            List bannerData = new ArrayList();
            bannerData.add(0);
            bannerData.add(1);
            bannerData.add(2);
            bannerData.add(3);
            IndexBannerAdapter adapter = new IndexBannerAdapter(mContext,bannerData);
            autoViewPager.setAdapter(adapter);
            autoViewPager.setInterval(3000);
            autoViewPager.setPageTransformer(false, new ScaleTransformer());
            autoViewPager.setCurrentItem(0);
            autoViewPager.startAutoScroll(3000);
            autoViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    autoTittleText.setText("一篇典型的surface book体验报告"+position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }

    class MultiItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
            if (mode == -1) return;//banner不管

            itemView.setOnClickListener(this);
            if (mode == Constants.LIST_MAJOR_PIC_MODE){

            }

            if (mode == Constants.LIST_MAJOR_TEXT_MODE){

            }

            if (mode == Constants.LIST_MULTI_PIC_MODE){

            }
        }

        @Override
        public void onClick(View v) {

        }
    }
}
