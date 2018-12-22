package com.zjmeow.bubble.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @description: 地图上的用户
 * @author: zjm
 **/

@Data
public class UserMapVO {
    private String username;
    private Integer id;
    private String avatar;
    private Date loginTime;
    private Double lat;
    private Double lng;
}
