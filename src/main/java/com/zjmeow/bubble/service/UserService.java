package com.zjmeow.bubble.service;

import com.zjmeow.bubble.model.dto.AvatarDTO;
import com.zjmeow.bubble.model.dto.InfoDTO;
import com.zjmeow.bubble.model.dto.LoginDTO;
import com.zjmeow.bubble.model.dto.RegisterDTO;
import com.zjmeow.bubble.model.vo.LoginVO;

/**
 * @description: 用户登录注册服务层
 * @author: zjm
 **/


public interface UserService {

    LoginVO login(LoginDTO loginDTO);

    void register(RegisterDTO registerDTO);

    void updateAvatar(AvatarDTO avatarDTO);

    void updateInfo(InfoDTO infoDTO);
}
