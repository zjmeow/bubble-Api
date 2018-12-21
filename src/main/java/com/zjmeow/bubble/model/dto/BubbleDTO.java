package com.zjmeow.bubble.model.dto;

import lombok.Data;

/**
 * @description: 发布新的bubble
 * @author: zjm
 **/

@Data
public class BubbleDTO {
    private Double lat;
    private Double lng;
    private String title;
    private String content;
    private String pic;
    private Integer userId;
}
