package com.android.WorkOutDay23;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.WorkOutDay23.application.KeepApplication;
import com.android.WorkOutDay23.base.BaseActivity;
import com.android.WorkOutDay23.bean.User;
import com.android.WorkOutDay23.databinding.ActivityLoginBinding;
import com.gyf.immersionbar.ImmersionBar;

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(mBinding.getRoot());
        initClick();
        ImmersionBar.with(this)
                .fitsSystemWindows(false)
                .init();
    }

    private void initClick() {
        mBinding.tvLoginLogin.setOnClickListener(view -> {
            if (mBinding.etLoginPhone.getText().toString().isEmpty()) {
                Toast.makeText(this, "Account", Toast.LENGTH_LONG).show();
                return;
            }
            if (mBinding.etLoginPassword.getText().toString().isEmpty()) {
                Toast.makeText(this, "Password", Toast.LENGTH_LONG).show();
                return;
            }
            User user = KeepApplication.db.userDao().login(mBinding.etLoginPhone.getText().toString(), mBinding.etLoginPassword.getText().toString());
            if (user == null) {
                Toast.makeText(this, "Username or Password incorrect", Toast.LENGTH_LONG).show();
                return;
            }
            KeepApplication.setLoginUser(user);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        mBinding.tvLoginRegister.setOnClickListener(view -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}