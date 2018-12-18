package com.zjmeow.bubble.service.impl;

import com.zjmeow.bubble.config.AuthRealm;
import com.zjmeow.bubble.dao.UserMapper;
import com.zjmeow.bubble.exception.TokenException;
import com.zjmeow.bubble.model.dto.LoginDTO;
import com.zjmeow.bubble.model.dto.RegisterDTO;
import com.zjmeow.bubble.model.po.User;
import com.zjmeow.bubble.model.vo.LoginVO;
import com.zjmeow.bubble.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    private final AuthRealm authRealm;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper,
                           UserMapper userMapper,
                           AuthRealm authRealm) {
        this.modelMapper = modelMapper;
        this.userMapper = userMapper;
        this.authRealm = authRealm;
    }

    @Override
    public LoginVO login(LoginDTO loginDTO) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginDTO.getPhone(), loginDTO.getPassword());
        subject.login(token);
        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token.toString());
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
