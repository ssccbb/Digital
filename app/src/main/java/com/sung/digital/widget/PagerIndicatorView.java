package com.sung.digital.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sung.digital.R;

/**
 * Created by sung on 2018/3/13.
 * 适用于viewpager的指示器
 */
public class PagerIndicatorView extends LinearLayout {
    private Context context;

    private int pagerCount = 1;
    private int selectPosition = 0;
    private onIndicatorClickListener onIndicatorClickListener;

    private static final int Indicator_Width = 15;//宽高
    private static final int Indicator_Margin = 8;//间距

    public PagerIndicatorView(Context context, int indicator_num) {
        super(context);
        this.context = context;
        this.pagerCount = indicator_num;
        inflater();
    }

    public PagerIndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.PagerIndicatorView);
        if (typedArray != null) {
            int count = typedArray.getInteger(R.styleable.PagerIndicatorView_indicator_count, 1);
            this.pagerCount = count;
            typedArray.recycle();
        }

        inflater();
    }

    private void inflater() {
        LinearLayout view = (LinearLayout) LayoutInflater.from(context)
                .inflate(R.layout.view_pager_indicator, null, false);

        if (pagerCount >= 1) {
            for (int i = 0; i < pagerCount; i++) {
                final ImageView indicator = new ImageView(context);
                indicator.setImageResource(R.drawable.page_indicator_selector);
                indicator.setTag(i);

                LayoutParams params =
                        new LayoutParams(Indicator_Width, Indicator_Width);
                params.setMargins(Indicator_Margin, 0, Indicator_Margin, 0);
                view.addView(indicator, params);

                indicator.setSelected(selectPosition == i);
                indicator.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onIndicatorClickListener != null) {
                            onIndicatorClickListener.onIndicatorClick((int) indicator.getTag());
                        }
                    }
                });
            }
        }

        this.removeAllViews();
        this.addView(view, new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    /**
     * 更改指示器状态
     *
     * @param select position
     */
    private void changeSelectStatus(int select) {
        if (select == this.selectPosition
                || select >= this.pagerCount)
            return;

        LinearLayout view = (LinearLayout) this.getChildAt(0);
        for (int i = 0; i < view.getChildCount(); i++) {
            if (view.getChildAt(i) instanceof ImageView) {
                ImageView indicator = (ImageView) view.getChildAt(i);
                indicator.setSelected(select == i);
            }
        }
    }

    /**
     * 指示器数量
     *
     * @param pagerCount 数
     */
    public void setPagerCount(int pagerCount) {
        this.pagerCount = pagerCount;
        inflater();
        changeSelectStatus(this.selectPosition);
    }

    public int getPagerCount() {
        return pagerCount;
    }

    /**
     * 选中状态更新
     *
     * @param select position
     */
    public void setSelectPosition(int select) {
        changeSelectStatus(select);
        this.selectPosition = select;
    }

    /**
     * 获取选中position
     */
    public int getSelectPosition() {
        return selectPosition;
    }

    public interface onIndicatorClickListener {
        void onIndicatorClick(int position);
    }

    public void addOnIndicatorClickListener(onIndicatorClickListener onIndicatorClickListener) {
        this.onIndicatorClickListener = onIndicatorClickListener;
    }
}
