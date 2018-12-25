package com.zjmeow.bubble.service;

import com.zjmeow.bubble.model.dto.*;
import com.zjmeow.bubble.model.vo.LoginVO;
import com.zjmeow.bubble.model.vo.UserDetailVO;
import com.zjmeow.bubble.model.vo.UserMapVO;

import java.util.List;

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

    /**
     * @param id 用户的id
     * @return : UserDetailVO
     * @description: 通过 id 获取用户详细信息，对应客户端的用户详情页面
     */
    UserDetailVO selectUserById(Integer id);

    /**
     * @description: 通过经纬度来获取附近的用户
     */
    List<UserMapVO> selectUserByLocation(Double lng, Double lat);

}
