package com.zjmeow.bubble.model.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: 登录DTO
 * @author: zjm
 **/

@Data
public class LoginDTO {
    @NotNull
    @ApiModelProperty(required = true, notes = "密码", example = "123456")
    private String password;
    @NotNull
    @ApiModelProperty(required = true, notes = "电话号码", example = "13101411913")
    private String phone;
    @NotNull
    @ApiModelProperty(required = true, notes = "客户端生成的token", example = "==")
    private String token;
}
