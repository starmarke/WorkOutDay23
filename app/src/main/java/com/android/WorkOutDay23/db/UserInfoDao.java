package com.android.WorkOutDay23.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;

import com.android.WorkOutDay23.bean.UserInfo;

@Dao
public interface UserInfoDao {


    @Insert
    void addUserInfo(UserInfo userInfo);


    @Update
    void updateUserInfo(UserInfo userInfo);
}
