package com.zjmeow.bubble.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @description:注册用DTO
 * @author: zjm
 **/

@Data
public class RegisterDTO {
    @ApiModelProperty(required = true, notes = "用户名", example = "zjmeow")
    @NotNull
    @Size(max = 8, min = 2)
    private String username;


    @ApiModelProperty(required = true, notes = "密码", example = "123456")
    @NotNull
    @Size(max = 16, min = 6)
    private String psw;

    @ApiModelProperty(required = true, notes = "电话号码", example = "13101411913")
    @NotNull
    @Size(max = 11, min = 11)
    private String phone;

    @ApiModelProperty(required = true, notes = "客户端生成的token", example = "==")
    @NotNull
    private String token;

}
