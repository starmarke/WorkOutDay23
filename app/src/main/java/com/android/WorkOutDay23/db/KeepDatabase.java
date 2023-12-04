package com.android.WorkOutDay23.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.android.WorkOutDay23.bean.User;
import com.android.WorkOutDay23.bean.UserInfo;


@Database(entities = {User.class, UserInfo.class}, version = 1, exportSchema = false)
public abstract class KeepDatabase extends RoomDatabase {
    public abstract UserDao userDao();


    public abstract UserInfoDao userInfoDao();


}
