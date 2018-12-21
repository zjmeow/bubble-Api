package com.zjmeow.bubble.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @description: 用户详情
 * @author: zjm
 **/

@Data
public class UserDetailVO {
    private String username;
    private Integer id;
    private String avatar;
    private String info;
    private Date loginTime;

}
