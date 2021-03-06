package com.zjmeow.bubble.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @description: bubble详情
 * @author: zjm
 **/

@Data
public class BubbleDetailVO {
    private Integer id;
    private Double lat;
    private Double lng;
    private String title;
    private String content;
    private String pic;
    private Integer userId;
    private Date createdTime;
    private Integer tap;
    private Date deadline;
    private String username;
    private String avatar;
}
