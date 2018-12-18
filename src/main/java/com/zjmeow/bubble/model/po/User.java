package com.zjmeow.bubble.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 用户数据
 * @author zjm
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer uid;
    private String username;
    private String password;
    private String lat;
    private String lng;
    private String token;

}