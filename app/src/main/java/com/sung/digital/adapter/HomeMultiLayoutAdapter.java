package com.sung.digital.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sung.digital.R;
import com.sung.digital.bean.HomeMultiListItemModel;
import com.sung.digital.common.Constants;
import com.sung.digital.widget.PagerIndicatorView;
import com.sung.digital.widget.banner.AutoScrollViewPager;
import com.sung.digital.widget.banner.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/5/4.
 *
 * 多布局adapter
 */

public class HomeMultiLayoutAdapter extends RecyclerView.Adapter {
    private static String TAG = HomeMultiLayoutAdapter.class.getSimpleName();
    private List<HomeMultiListItemModel> mData = new ArrayList();
    private boolean hasBanner = false;
    private boolean hasDailyQuotation = false;
    private Context mContext;

    public HomeMultiLayoutAdapter(Context context, List<HomeMultiListItemModel> mData, boolean hasBanner, boolean hasDailyQuotation) {
        this.mData = mData;
        this.hasBanner = hasBanner;
        this.hasDailyQuotation = hasDailyQuotation;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == Constants.LIST_BANNER_MODE){
            view = inflater.inflate(R.layout.view_banner,parent,false);
            view.setTag(Constants.LIST_BANNER_MODE);
            return new BannerItemHolder(view);
        }
        if (viewType == Constants.LIST_DAILY_QUOTATION_MODE){
            view = inflater.inflate(R.layout.view_daily_quotes,parent,false);
            view.setTag(Constants.LIST_DAILY_QUOTATION_MODE);
            return new DailyQuotationHolder(view);
        }
        if (viewType == Constants.LIST_MAJOR_TEXT_MODE){
            view = inflater.inflate(R.layout.view_index_item_major_text, parent, false);
            view.setTag(Constants.LIST_MAJOR_TEXT_MODE);
        }
        if (viewType == Constants.LIST_MAJOR_PIC_MODE){
            view = inflater.inflate(R.layout.view_index_item_major_pic, parent, false);
            view.setTag(Constants.LIST_MAJOR_PIC_MODE);
        }
        if (view == null) {
            view = inflater.inflate(R.layout.view_index_item_multi_pic, parent, false);
            view.setTag(Constants.LIST_MULTI_PIC_MODE);
        }
        return new MultiItemHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (hasBanner && position == 0){
            return Constants.LIST_BANNER_MODE;
        }
        if (hasDailyQuotation && position == 1){
            return Constants.LIST_DAILY_QUOTATION_MODE;
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
            int data_position = position;
            if (hasBanner){
                data_position--;
            }
            if (hasDailyQuotation){
                data_position--;
            }
            multiItemHolder.onBind(data_position);
        }
        if (holder instanceof BannerItemHolder){
            BannerItemHolder bannerItemHolder = (BannerItemHolder) holder;
            bannerItemHolder.onBind();
        }
        if (holder instanceof DailyQuotationHolder){
            DailyQuotationHolder dailyQuotationHolder = (DailyQuotationHolder) holder;
            dailyQuotationHolder.onBind();
        }
    }

    @Override
    public int getItemCount() {
        int count = mData.size();
        if (hasBanner){
            count = count + 1;
        }
        if (hasDailyQuotation){
            count = count + 1;
        }
        return count;
    }

    class BannerItemHolder extends RecyclerView.ViewHolder {
        private AutoScrollViewPager autoViewPager;
        private PagerIndicatorView autoIndicator;
        private TextView autoTittleText;

        public BannerItemHolder(View itemView) {
            super(itemView);
            autoViewPager = itemView.findViewById(R.id.auto_scroll_view_pager);
            autoIndicator = itemView.findViewById(R.id.auto_scroll_pager_indicator);
            autoTittleText = itemView.findViewById(R.id.auto_scroll_pager_tittle);
        }

        void onBind(){
            List bannerData = new ArrayList();
            bannerData.add(0);
            bannerData.add(1);
            bannerData.add(2);
            bannerData.add(3);
            autoIndicator.setPagerCount(4);
            autoIndicator.setVisibility(View.VISIBLE);
            HomeBannerAdapter adapter = new HomeBannerAdapter(mContext,bannerData);
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
                    autoIndicator.setSelectPosition(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }

    class DailyQuotationHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private View root;
        private ImageView close;
        private TextView more;

        public DailyQuotationHolder(View itemView) {
            super(itemView);
            root = itemView;
            close = itemView.findViewById(R.id.iv_daily_close);
            more = itemView.findViewById(R.id.tv_daily_more);
        }

        void onBind(){
            root.setOnClickListener(this);
            close.setOnClickListener(this);
            more.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v == close){
                hasDailyQuotation = false;
                HomeMultiLayoutAdapter.this.notifyDataSetChanged();
            }
            if (v == more){

            }
            if (v == root){

            }
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
            HomeMultiListItemModel data = mData.get(position);
            if (mode == -1 || mode == -2) return;//banner&每日一言不管

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
