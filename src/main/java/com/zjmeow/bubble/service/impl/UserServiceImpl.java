package com.zjmeow.bubble.service.impl;

import com.zjmeow.bubble.dao.UserMapper;
import com.zjmeow.bubble.model.dto.*;
import com.zjmeow.bubble.model.po.User;
import com.zjmeow.bubble.model.po.UserLocation;
import com.zjmeow.bubble.model.vo.LoginVO;
import com.zjmeow.bubble.model.vo.UserDetailVO;
import com.zjmeow.bubble.model.vo.UserMapVO;
import com.zjmeow.bubble.service.UserService;
import com.zjmeow.bubble.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
        loginVO.setId(user.getId());
        loginVO.setUsername(user.getUsername());
        return loginVO;
    }

    @Override
    public void register(RegisterDTO registerDTO) {
        User user = modelMapper.map(registerDTO, User.class);
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

    @Override
    public void updateLocation(LocationDTO locationDTO) {
        UserLocation location = new UserLocation();
        location.setId(JWTUtil.getCurrentUserId());
        location.setLocation("POINT(" + locationDTO.getLng() + " " + locationDTO.getLat() + ")");
        location.setLoginTime(locationDTO.getLoginTime());
        userMapper.updateLocation(location);
    }

    @Override
    public UserDetailVO selectUserById(Integer id) {
        User user = userMapper.selectUserDetailById(id);
        return modelMapper.map(user, UserDetailVO.class);
    }

    @Override
    public List<UserMapVO> selectUserByLocation(Double lng, Double lat) {
        String point = "location<-> SRID=4326;POINT(" + lng + " " + lat + ")::geometry";
        List<User> users = userMapper.selectUserByLocation(point);
        return modelMapper.map(users, new TypeToken<List<UserMapVO>>() {
        }.getType());
    }
}
