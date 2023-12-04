package com.android.WorkOutDay23.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.WorkOutDay23.R;
import com.android.WorkOutDay23.bean.SportBean;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;


public class HomeListAdapter extends BaseQuickAdapter<SportBean, BaseViewHolder> {


    public HomeListAdapter(@Nullable List<SportBean> data) {
        super(R.layout.item_home_sport_list, data);
        addChildClickViewIds(R.id.iv_item_home_share);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, SportBean sportBean) {
        ImageView view = baseViewHolder.getView(R.id.iv_sport_img);
        Glide.with(getContext())
                .load(sportBean.getImg())
                .into(view);
        baseViewHolder.setText(R.id.tv_item_sport_name,sportBean.getName());
        baseViewHolder.setText(R.id.tv_item_sport_desc,sportBean.getDesc());
    }
}
