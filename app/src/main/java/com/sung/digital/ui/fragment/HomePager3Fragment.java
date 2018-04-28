package com.sung.digital.ui.fragment;

import com.sung.digital.R;
import com.sung.digital.common.BaseFragment;

/**
 * Created by sung on 2018/4/24.
 */

public class HomePager3Fragment extends BaseFragment {
    private static HomePager3Fragment instance;

    public static HomePager3Fragment newInstance(){
        if (instance != null){
            return instance;
        }
        return new HomePager3Fragment();
    }

    public HomePager3Fragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_pager_3;
    }

    @Override
    public void initView() {
    }

    @Override
    public void setData() {

    }

}
