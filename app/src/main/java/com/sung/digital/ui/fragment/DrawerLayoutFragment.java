package com.sung.digital.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sung.digital.R;
import com.sung.digital.common.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2018/4/27.
 */

public class DrawerLayoutFragment extends BaseFragment {
    private RecyclerView mList;
    private List mMenus = new ArrayList();

    @Override
    public int getLayoutId() {
        return R.layout.fragment_drawer_layout;
    }

    @Override
    public void initView() {
        mList = findView(R.id.list_menu);
    }

    @Override
    public void setData() {
        for (int i = 0; i < 10; i++) {
            mMenus.add(i);
        }
        MenuAdapter adapter = new MenuAdapter();
        mList.setItemAnimator(new DefaultItemAnimator());
        mList.setHasFixedSize(true);
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        mList.setAdapter(adapter);
    }

    class MenuAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MenuHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_drawer_list_item,null,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mMenus.size();
        }

        class MenuHolder extends RecyclerView.ViewHolder {

            public MenuHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }

            void onBind(int position){

            }
        }
    }
}
