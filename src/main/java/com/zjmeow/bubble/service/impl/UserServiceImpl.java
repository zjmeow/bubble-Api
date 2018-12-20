package com.zjmeow.bubble.service.impl;

import com.zjmeow.bubble.dao.UserMapper;
import com.zjmeow.bubble.exception.TokenException;
import com.zjmeow.bubble.model.dto.LoginDTO;
import com.zjmeow.bubble.model.dto.RegisterDTO;
import com.zjmeow.bubble.model.po.User;
import com.zjmeow.bubble.model.vo.LoginVO;
import com.zjmeow.bubble.service.UserService;
import com.zjmeow.bubble.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @description: 用户登录注册服务实现层
 * @author: zjm
 **/

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper,
                           UserMapper userMapper) {
        this.modelMapper = modelMapper;
        this.userMapper = userMapper;
    }

    @Override
    public LoginVO login(LoginDTO loginDTO) {
        LoginVO loginVO = new LoginVO();
        loginVO.setToken(JWTUtil.sign(loginDTO.getPhone(), loginDTO.getPassword()));
        return loginVO;
    }

    @Override
    public void register(RegisterDTO registerDTO) {
        if (!md5(registerDTO.getPhone()).equals(registerDTO.getToken())) {
            throw new TokenException();
        }
        User user = modelMapper.map(registerDTO, User.class);
        userMapper.createUser(user);

    }

    private String md5(String text) {
        if (text == null) throw new TokenException();
        String salt = text + "stonymoon";
        return new String(DigestUtils.md5Digest(salt.getBytes()));
    }
}
