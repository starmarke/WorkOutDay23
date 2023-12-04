package com.android.WorkOutDay23.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.android.WorkOutDay23.bean.User;


@Dao
public interface UserDao {


    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    User login(String username, String password);


    @Insert
    void addUser(User user);

}
