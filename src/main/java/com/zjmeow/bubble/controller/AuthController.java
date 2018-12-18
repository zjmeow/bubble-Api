package com.zjmeow.bubble.controller;

import com.zjmeow.bubble.model.dto.LoginDTO;
import com.zjmeow.bubble.model.dto.RegisterDTO;
import com.zjmeow.bubble.model.vo.ApiResponse;
import com.zjmeow.bubble.model.vo.LoginVO;
import com.zjmeow.bubble.model.vo.RegisterVO;
import com.zjmeow.bubble.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description: 登录注册模块
 * @author: zjm
 **/

@RestController
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    ApiResponse<LoginVO> login(LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }


    @GetMapping("/register")
    ApiResponse<RegisterVO> register(RegisterDTO registerDTO) {
        return userService.register(registerDTO);

    }
}
