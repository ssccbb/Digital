package com.sung.digital.ui.fragment;

import com.sung.digital.R;
import com.sung.digital.common.BaseFragment;

/**
 * Created by sung on 2018/4/24.
 */

public class NoticePagerFragment extends BaseFragment {
    private static NoticePagerFragment instance;

    public static NoticePagerFragment newInstance(){
        if (instance != null){
            return instance;
        }
        return new NoticePagerFragment();
    }

    public NoticePagerFragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_notice_pager;
    }

    @Override
    public void initView() {
    }

    @Override
    public void setData() {

    }

}
