package com.zjmeow.bubble.dao;

import com.zjmeow.bubble.model.po.User;

public interface UserMapper {
    User selectUserByPhone(String phone);

    void insertUser(User user);

    User selectUserPasswordById(Integer id);

    void updateAvatar(User user);

    void updateInfo(User user);

}