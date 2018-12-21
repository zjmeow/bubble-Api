package com.zjmeow.bubble.service;

import com.zjmeow.bubble.model.dto.*;
import com.zjmeow.bubble.model.vo.LoginVO;
import com.zjmeow.bubble.model.vo.UserDetailVO;

/**
 * @description: 用户登录注册服务层
 * @author: zjm
 **/


public interface UserService {

    LoginVO login(LoginDTO loginDTO);

    void register(RegisterDTO registerDTO);

    void updateAvatar(AvatarDTO avatarDTO);

    void updateInfo(InfoDTO infoDTO);

    void updateLocation(LocationDTO locationDTO);

    UserDetailVO selectUserById(Integer id);
}
