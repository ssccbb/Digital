package com.sung.digital.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sung.digital.R;

/**
 * Created by sung on 2018/5/7.
 */

public class RecyclerDecoration extends RecyclerView.ItemDecoration {
    private Paint dividerPaint;
    private int dividerHeight;

    public RecyclerDecoration(Context context) {
        dividerPaint = new Paint();
        dividerPaint.setColor(context.getResources().getColor(R.color.colorDivider));
        dividerHeight = (int) context.getResources().getDimension(R.dimen.common_divider_normal_height);
    }

    public RecyclerDecoration(Context context, int resColor, int resHeight) {
        dividerPaint = new Paint();
        dividerPaint.setColor(context.getResources().getColor(resColor));
        dividerHeight = (int) context.getResources().getDimension(resHeight);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = dividerHeight;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            float bottom = childAt.getBottom() + dividerHeight;
            c.drawRect(parent.getPaddingLeft(),
                    childAt.getBottom(),
                    parent.getWidth() - parent.getPaddingRight(),
                    bottom,
                    dividerPaint);
        }
    }
}
