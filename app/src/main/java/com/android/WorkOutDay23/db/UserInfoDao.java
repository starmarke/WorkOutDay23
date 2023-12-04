package com.android.WorkOutDay23.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.android.WorkOutDay23.bean.UserInfo;

@Dao
public interface UserInfoDao {


    @Insert
    void addUserInfo(UserInfo userInfo);


    @Update
    void updateUserInfo(UserInfo userInfo);


//    @Query("UPDATE user_info SET name = :newName, age = :newAge, weight = :newWeight,height = :newHeight WHERE userId = :userId")
//    void updateUserInfoById(int userId, String newName, String newAge, String newWeight, String newHeight);
//
//
//    @Query("SELECT * FROM user_info WHERE userId = :userId")
//    UserInfo getUserInfoById(int userId);
}
