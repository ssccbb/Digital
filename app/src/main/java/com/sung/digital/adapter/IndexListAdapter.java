package com.sung.digital.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sung.digital.R;
import com.sung.digital.widget.banner.AutoScrollViewPager;
import com.sung.digital.widget.banner.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/5/3.
 */

public class IndexListAdapter extends RecyclerView.Adapter {
    private List data = new ArrayList();
    private Context mContext;

    public IndexListAdapter(Context context, List data) {
        this.mContext = context;
        if (data != null){
            this.data = data;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0){
            return new BannerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_banner,null,false));
        }
        return new ListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_item,null,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  ListHolder)
            ((ListHolder)holder).onBind(position - 1);

        if (holder instanceof BannerHolder)
            ((BannerHolder)holder).onBind();
    }

    @Override
    public int getItemCount() {
        return data.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 0;
        }
        return 1;
    }

    class BannerHolder extends RecyclerView.ViewHolder {
        private AutoScrollViewPager autoViewPager;

        public BannerHolder(View itemView) {
            super(itemView);
            autoViewPager = itemView.findViewById(R.id.auto_scroll_view_pager);
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
        }
    }

    class ListHolder extends RecyclerView.ViewHolder {
        private TextView text;

        public ListHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }

        void onBind(final int position){
            text.setText(String.valueOf(/*data.get(position)*/position));
        }
    }
}
