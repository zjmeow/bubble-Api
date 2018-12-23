package com.zjmeow.bubble.model.vo;

import lombok.Data;

/**
 * @description: 登录VO
 * @author: zjm
 **/

@Data
public class LoginVO {
    private Integer id;
    private String username;
    private String token;
}
