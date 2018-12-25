package com.zjmeow.bubble.model.po;

import lombok.Data;

import java.util.Date;

/**
 * @description: 用来更新地理位置，通过location传入位置
 * @author: zjm
 **/

@Data
public class UserLocation {
    private String location;
    private Integer id;
    private Date loginTime;
}
