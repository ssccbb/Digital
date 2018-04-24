package com.sung.digital.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sung.digital.R;
import com.sung.digital.bean.TabIndicatorModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/4/24.
 */

public class TabIndicatorView extends LinearLayout {
    public static final String TAG = TabIndicatorView.class.getSimpleName();
    private List<TabIndicatorModel> models = new ArrayList();
    private List<TabIndicator> indicators = new ArrayList();

    public TabIndicatorView(Context context) {
        super(context);
        initView();
    }

    public TabIndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TabIndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initData(){
        TabIndicatorModel tab1 = new TabIndicatorModel("照片", R.drawable.ic_menu_camera);
        TabIndicatorModel tab2 = new TabIndicatorModel("相册", R.drawable.ic_menu_gallery);
        TabIndicatorModel tab3 = new TabIndicatorModel("发送", R.drawable.ic_menu_send);
        TabIndicatorModel tab4 = new TabIndicatorModel("视频", R.drawable.ic_menu_slideshow);
        models.add(tab1);
        models.add(tab2);
        models.add(tab3);
        models.add(tab4);
    }

    private void initView(){
        initData();
        if (models == null || models.isEmpty()) return;
        this.setGravity(LinearLayout.HORIZONTAL | Gravity.CENTER);
        for (int i = 0; i < models.size(); i++) {
            addIndicator(i);
        }

        this.select(0);
    }

    private void addIndicator(final int position){
        if (models == null) models = new ArrayList<>();

        TabIndicator indicator = new TabIndicator(this.getContext(),models.get(position));
        indicator.setTag(position);
        indicator.bindParent(this);
        indicators.add(indicator);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        this.addView(indicator,params);

        indicator.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(position);
            }
        });
    }

    public void select(int position){
        for (int i = 0; i < indicators.size(); i++) {
            TabIndicator indicator = indicators.get(i);
            if (i == position){
                indicator.selected();
            }else {
                indicator.unselected();
            }
        }
    }

    public void show(){

    }

    public void hide(){

    }

}
