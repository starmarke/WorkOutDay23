package com.android.WorkOutDay23.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.WorkOutDay23.R;
import com.android.WorkOutDay23.WebViewActivity;
import com.android.WorkOutDay23.adapter.HomeListAdapter;
import com.android.WorkOutDay23.bean.SportBean;
import com.android.WorkOutDay23.databinding.FragmentHomeBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding mBinding;


    private List<SportBean> mData = new ArrayList<>();
    private HomeListAdapter mAdapter = new HomeListAdapter(mData);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.rvHomeSportList.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", mAdapter.getData().get(position).getLinkUrl());
                startActivity(intent);
            }
        });

        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                shareToFacebook(mAdapter.getData().get(position).getDesc());
            }
        });
        initData();
    }

    private void initData() {
        mData.clear();

        SportBean sportBean1 = new SportBean();
        sportBean1.setLinkUrl(" https://youtu.be/Eml2xnoLpYE?si=KYJexYFJvqtXgvgI");
        sportBean1.setName("Yoga");
        sportBean1.setImg(R.mipmap.pic_one);
        sportBean1.setDesc("Yoga helps you to have a balanced body and mind");
        mData.add(sportBean1);

        SportBean sportBean2 = new SportBean();
        sportBean2.setLinkUrl("https://youtu.be/f3zOrYCwquE?si=ZERawt3H1sAECbSF");
        sportBean2.setName("Warm-Up");
        sportBean2.setImg(R.mipmap.pic_two);
        sportBean2.setDesc("Get ready to do exercise");
        mData.add(sportBean2);

        SportBean sportBean3 = new SportBean();
        sportBean3.setLinkUrl("https://youtu.be/rK_tmffSghQ?si=91iFvvwoUKoNE4Er");
        sportBean3.setName("Abs Exercise");
        sportBean3.setImg(R.mipmap.pic_three);
        sportBean3.setDesc("Strengthen your abs");
        mData.add(sportBean3);

        mAdapter.notifyDataSetChanged();
    }


    private void shareToFacebook(String desc) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, desc);
        intent.setPackage("com.facebook.katana");

        try {
            startActivity(intent);
        } catch (android.content.ActivityNotFoundException ex) {

            intent.setPackage(null);
            intent.setData(Uri.parse("https://www.facebook.com/sharer/sharer.php?u="));
            startActivity(Intent.createChooser(intent, "Share with"));
        }
    }

}
