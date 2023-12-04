package com.android.WorkOutDay23.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.WorkOutDay23.EditInfoActivity;
import com.android.WorkOutDay23.LoginActivity;
import com.android.WorkOutDay23.application.KeepApplication;
import com.android.WorkOutDay23.bean.UserInfo;
import com.android.WorkOutDay23.databinding.FragmentPersonalBinding;


public class PersonalFragment extends Fragment {

    private FragmentPersonalBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentPersonalBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (KeepApplication.getLoginUser() != null) {
            mBinding.tvUserName.setText(KeepApplication.getLoginUser().getPhone());
        }

        mBinding.tvPersonalLogOut.setOnClickListener(view1 -> {
            KeepApplication.setLoginUser(null);
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
        });

        mBinding.ivPersonalEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), EditInfoActivity.class));
            }
        });
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        UserInfo userInfoById = KeepApplication.db.userInfoDao().getUserInfoById(KeepApplication.getLoginUser().getId());
//        if (userInfoById == null){
//            return;
//        }
//        mBinding.tvUserName.setText(userInfoById.getName());
//        mBinding.tvUserAge.setText("age :"+userInfoById.getAge());
//        mBinding.tvUserWeight.setText("weight :"+userInfoById.getWeight());
//        mBinding.tvUserHeight.setText("height :"+userInfoById.getHeight());
//    }
}
