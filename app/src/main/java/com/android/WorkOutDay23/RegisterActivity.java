package com.android.WorkOutDay23;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.WorkOutDay23.application.KeepApplication;
import com.android.WorkOutDay23.bean.User;
import com.android.WorkOutDay23.databinding.ActivityRegisterBinding;
import com.gyf.immersionbar.ImmersionBar;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(mBinding.getRoot());

        ImmersionBar.with(this).fitsSystemWindows(false).statusBarDarkFont(true).init();

        initClick();

    }

    private void initClick() {
        mBinding.ivRegisterBack.setOnClickListener(view -> {
            finish();
        });
        mBinding.tvRegisterWatch.setOnClickListener(view -> {
            finish();
        });

        mBinding.tvRegisterRegister.setOnClickListener(view -> {
            if (mBinding.etRegisterAccount.getText().toString().isEmpty()) {
                Toast.makeText(this, " Please enter your account number", Toast.LENGTH_LONG).show();
                return;
            }
            if (mBinding.etRegisterPassword.getText().toString().isEmpty()) {
                Toast.makeText(this, " Please enter your account password", Toast.LENGTH_LONG).show();
                return;
            }
            User user = new User();
            user.setPhone(mBinding.etRegisterAccount.getText().toString());
            user.setPassword(mBinding.etRegisterPassword.getText().toString());
            KeepApplication.db.userDao().addUser(user);
            Toast.makeText(this, "Registration successful", Toast.LENGTH_LONG).show();
            KeepApplication.setLoginUser(user);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}