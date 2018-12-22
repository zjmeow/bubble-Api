package com.zjmeow.bubble.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @description: 附近地图上的bubble
 * @author: zjm
 **/

@Data
public class BubbleMapVO {
    private Integer id;
    private Double lat;
    private Double lng;
    private String title;
    private String pic;
    private Integer userId;
    private Date createdTime;
}
