package com.zjmeow.bubble.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @description: 评论
 * @author: zjm
 **/

@Data
public class CommentVO {
    private Date createdTime;
    private String avatar;
    private Integer userId;
    private Integer tap;
    private String content;
}
