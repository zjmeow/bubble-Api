package com.zjmeow.bubble.controller;

import com.zjmeow.bubble.model.dto.AvatarDTO;
import com.zjmeow.bubble.model.dto.InfoDTO;
import com.zjmeow.bubble.model.vo.ApiResponse;
import com.zjmeow.bubble.service.UserService;
import com.zjmeow.bubble.util.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 用户资料控制器
 * @author: zjm
 **/

@RestController
public class UserController {
    final
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/avatar")
    ApiResponse<String> uploadAvatar(AvatarDTO avatarDTO) {
        userService.uploadAvatar(avatarDTO);
        return RestResultGenerator.genResult("上传成功", "ok");
    }

    @PostMapping("/info")
    ApiResponse<String> updateInfo(InfoDTO infoDTO) {
        userService.updateInfo(infoDTO);
        return RestResultGenerator.genResult("修改成功", "ok");
    }

}
