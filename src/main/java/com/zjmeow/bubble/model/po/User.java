package com.zjmeow.bubble.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private Integer id;

    private String lat;

    private String lng;

    private String token;

    private String avatar;
    private String psw;
    private String info;

    private String phone;
}