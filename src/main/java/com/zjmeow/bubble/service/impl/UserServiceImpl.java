package com.zjmeow.bubble.service.impl;

import com.zjmeow.bubble.exception.TokenException;
import com.zjmeow.bubble.model.dto.LoginDTO;
import com.zjmeow.bubble.model.dto.RegisterDTO;
import com.zjmeow.bubble.model.vo.ApiResponse;
import com.zjmeow.bubble.model.vo.LoginVO;
import com.zjmeow.bubble.model.vo.RegisterVO;
import com.zjmeow.bubble.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @description: 用户登录注册服务实现层
 * @author: zjm
 **/

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public ApiResponse<LoginVO> login(LoginDTO loginDTO) {
        return null;
    }

    @Override
    public ApiResponse<RegisterVO> register(RegisterDTO registerDTO) {
        String salt = registerDTO.getPhone() + "stonymoon";
        String token = new String(DigestUtils.md5Digest(salt.getBytes()));
        if (!registerDTO.getToken().equals(token)) {
            throw new TokenException();
        }


        return null;
    }
}
