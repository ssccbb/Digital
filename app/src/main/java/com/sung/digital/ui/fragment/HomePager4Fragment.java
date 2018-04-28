package com.sung.digital.ui.fragment;

import com.sung.digital.R;
import com.sung.digital.common.BaseFragment;

/**
 * Created by sung on 2018/4/24.
 */

public class HomePager4Fragment extends BaseFragment {
    private static HomePager4Fragment instance;

    public static HomePager4Fragment newInstance(){
        if (instance != null){
            return instance;
        }
        return new HomePager4Fragment();
    }

    public HomePager4Fragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_pager_4;
    }

    @Override
    public void initView() {
    }

    @Override
    public void setData() {

    }

}
