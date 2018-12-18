package com.zjmeow.bubble.service;

import com.zjmeow.bubble.model.dto.LoginDTO;
import com.zjmeow.bubble.model.dto.RegisterDTO;
import com.zjmeow.bubble.model.vo.ApiResponse;
import com.zjmeow.bubble.model.vo.LoginVO;
import com.zjmeow.bubble.model.vo.RegisterVO;

/**
 * @description: 用户登录注册服务层
 * @author: zjm
 **/


public interface UserService {

    ApiResponse<LoginVO> login(LoginDTO loginDTO);

    ApiResponse<RegisterVO> register(RegisterDTO registerDTO);
}
