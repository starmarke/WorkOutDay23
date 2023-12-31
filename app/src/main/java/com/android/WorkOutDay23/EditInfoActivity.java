package com.android.WorkOutDay23;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.WorkOutDay23.application.KeepApplication;
import com.android.WorkOutDay23.bean.UserInfo;
import com.android.WorkOutDay23.databinding.ActivityEditInfoBinding;

public class EditInfoActivity extends AppCompatActivity {

    private ActivityEditInfoBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityEditInfoBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.ivEditBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mBinding.tvEditSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBinding.etEditName.getText().toString().isEmpty()) {
                    Toast.makeText(EditInfoActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mBinding.etEditAge.getText().toString().isEmpty()) {
                    Toast.makeText(EditInfoActivity.this, "Please enter your age", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mBinding.etEditHight.getText().toString().isEmpty()) {
                    Toast.makeText(EditInfoActivity.this, "Please enter your height", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mBinding.etEditWeight.getText().toString().isEmpty()) {
                    Toast.makeText(EditInfoActivity.this, "Please enter your weight", Toast.LENGTH_SHORT).show();
                    return;
                }
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(KeepApplication.getLoginUser().getId());
                userInfo.setName(mBinding.etEditName.getText().toString());
                userInfo.setAge(mBinding.etEditAge.getText().toString());
                userInfo.setHeight(mBinding.etEditHight.getText().toString());
                userInfo.setWeight(mBinding.etEditWeight.getText().toString());
                UserInfo userInfoById = KeepApplication.db.userInfoDao().getUserInfoById(userInfo.getUserId());
                if (userInfoById == null){
                    KeepApplication.db.userInfoDao().addUserInfo(userInfo);
                } else {
                    KeepApplication.db.userInfoDao().updateUserInfoById(userInfo.getUserId(), userInfo.getName(),
                            userInfo.getAge(), userInfo.getWeight(), userInfo.getHeight());
                }

                Toast.makeText(EditInfoActivity.this,"Information saved",Toast.LENGTH_LONG).show();
            }
        });
    }
}