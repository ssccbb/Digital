package com.sung.digital.ui.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.sung.digital.widget.TabIndicator;
import com.sung.digital.widget.TabIndicatorView;

/**
 * Created by sung on 2018/4/24.
 */

public class HomeScrollBehavior extends CoordinatorLayout.Behavior<TabIndicatorView> {
    private int mStartY = 0;

    public HomeScrollBehavior() {
    }

    public HomeScrollBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, TabIndicatorView child, int layoutDirection) {
        ((CoordinatorLayout.LayoutParams) child.getLayoutParams()).topMargin
                = parent.getMeasuredHeight() - child.getMeasuredHeight();
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TabIndicatorView child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TabIndicatorView child,
                                          View dependency) {
        int top = ((AppBarLayout.Behavior) ((CoordinatorLayout.LayoutParams)
                dependency.getLayoutParams()).getBehavior()).getTopAndBottomOffset();
        //移动距离
        int translateY = top - mStartY;
        //10 安全位移
        if (Math.abs(translateY) <= 10){
            mStartY = top;
            return false;
        }else {
            //正数手势下滑 动画出现
            if (translateY > 0) {
                child.show();
            }
            //负数手势赏花 动画消失
            else if (translateY < 0){
                child.hide();
            }
            mStartY = top;
        }
        return false;
    }
}
