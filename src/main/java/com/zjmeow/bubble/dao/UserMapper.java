package com.zjmeow.bubble.dao;

import com.zjmeow.bubble.model.po.User;
import com.zjmeow.bubble.model.po.UserLocation;

import java.util.List;

public interface UserMapper {
    User selectUserByPhone(String phone);

    void insertUser(User user);

    User selectUserPasswordById(Integer id);

    void updateAvatar(User user);

    void updateInfo(User user);

    void updateLocation(UserLocation user);

    User selectUserDetailById(Integer id);

    List<User> selectUserByLocation(String point);
}