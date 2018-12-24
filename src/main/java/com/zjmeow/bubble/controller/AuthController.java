package com.zjmeow.bubble.controller;

import com.zjmeow.bubble.model.dto.LoginDTO;
import com.zjmeow.bubble.model.dto.RegisterDTO;
import com.zjmeow.bubble.model.vo.ApiResponse;
import com.zjmeow.bubble.model.vo.LoginVO;
import com.zjmeow.bubble.service.UserService;
import com.zjmeow.bubble.util.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @description: 登录注册控制器
 * @author: zjm
 **/
@Validated
@RequestMapping(value = "/auth")
@RestController
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    ApiResponse<LoginVO> login(@Valid LoginDTO loginDTO) {

        return RestResultGenerator.genResult(userService.login(loginDTO), "ok");

    }


    @PostMapping("/register")
    ApiResponse<String> register(@Valid RegisterDTO registerDTO) {
        userService.register(registerDTO);
        return RestResultGenerator.genResult("注册成功", "ok");
    }


}
