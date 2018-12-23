package com.zjmeow.bubble.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @description: bubble列表VO
 * @author: zjm
 **/

@Data
public class BubbleListVO {
    private Integer id;
    private Double lat;
    private Double lng;
    private String title;
    private String pic;
    private Date createdTime;
    private String content;
    private Integer tap;
}
