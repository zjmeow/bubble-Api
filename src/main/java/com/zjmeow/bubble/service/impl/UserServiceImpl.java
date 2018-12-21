package com.zjmeow.bubble.service.impl;

import com.zjmeow.bubble.dao.UserMapper;
import com.zjmeow.bubble.model.dto.AvatarDTO;
import com.zjmeow.bubble.model.dto.InfoDTO;
import com.zjmeow.bubble.model.dto.LoginDTO;
import com.zjmeow.bubble.model.dto.RegisterDTO;
import com.zjmeow.bubble.model.po.User;
import com.zjmeow.bubble.model.vo.LoginVO;
import com.zjmeow.bubble.service.UserService;
import com.zjmeow.bubble.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
        // phone 只会在这里使用，其他时候都使用的id
        User user = userMapper.selectUserByPhone(loginDTO.getPhone());
        if (user == null) throw new AuthenticationException();
        loginVO.setToken(JWTUtil.sign(user.getId() + "", loginDTO.getPassword()));
        return loginVO;
    }

    @Override
    public void register(RegisterDTO registerDTO) {
        System.out.println(JWTUtil.getCurrentUserId());
        User user = modelMapper.map(registerDTO, User.class);
        log.info(user.toString());
        userMapper.insertUser(user);
    }


    @Override
    public void updateAvatar(AvatarDTO avatarDTO) {
        User user = modelMapper.map(avatarDTO, User.class);
        user.setId(JWTUtil.getCurrentUserId());
        userMapper.updateAvatar(user);

    }

    @Override
    public void updateInfo(InfoDTO infoDTO) {
        User user = modelMapper.map(infoDTO, User.class);
        user.setId(JWTUtil.getCurrentUserId());
        userMapper.updateInfo(user);

    }
}
