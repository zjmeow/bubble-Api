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
    private int id;
    private int bubbleId;
    private int userId;
    private int tap;
    private String content;
}
