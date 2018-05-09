package com.sung.digital.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sung.digital.R;
import com.sung.digital.bean.FindPicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/5/9.
 */

public class FindWaterFallAdapter extends RecyclerView.Adapter {
    private List<FindPicModel> mData = new ArrayList<>();
    private Context mContext;

    public FindWaterFallAdapter(Context mContext,List<FindPicModel> mData) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_water_pic_item,parent,false);
        return new WaterFallPicHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof WaterFallPicHolder){
            WaterFallPicHolder waterFallPicHolder = (WaterFallPicHolder) holder;
            waterFallPicHolder.onBind(position);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class WaterFallPicHolder extends RecyclerView.ViewHolder {
        private ImageView pic;

        public WaterFallPicHolder(View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.iv_pic);
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) pic.getLayoutParams();
            params.height = dp2px(mContext,(float) (250 + Math.random() * 150));
            pic.setLayoutParams(params);
        }

        int dp2px(Context context, float dipValue) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (dipValue * scale + 0.5f);
        }

        void onBind(int position){

        }
    }
}
