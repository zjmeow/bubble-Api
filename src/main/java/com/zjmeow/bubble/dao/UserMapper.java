package com.zjmeow.bubble.dao;

import com.zjmeow.bubble.model.po.User;

public interface UserMapper {
    User selectUserByPhone(String phone);

    void createUser(User user);

    User selectPassword(String phone);


}