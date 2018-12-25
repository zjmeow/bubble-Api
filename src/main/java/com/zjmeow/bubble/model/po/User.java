package com.zjmeow.bubble.model.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 用户信息
 * @author: zjm
 **/

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private Integer id;

    private Double lat;

    private Double lng;

    private String avatar;
    private String psw;
    private String info;

    private String phone;

    private Date loginTime;
}