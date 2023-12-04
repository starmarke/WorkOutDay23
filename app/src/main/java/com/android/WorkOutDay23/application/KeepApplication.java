package com.android.WorkOutDay23.application;

import android.app.Application;

import androidx.room.Room;

import com.android.WorkOutDay23.bean.User;
import com.android.WorkOutDay23.db.KeepDatabase;


public class KeepApplication extends Application {

    public static KeepDatabase db;

    private static User loginUser = null;

    public static User getLoginUser() {
        return loginUser;
    }

    public static void setLoginUser(User loginUser) {
        KeepApplication.loginUser = loginUser;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(), KeepDatabase.class, "keep")
                .allowMainThreadQueries()
                .build();
    }
}
