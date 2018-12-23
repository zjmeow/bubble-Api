package com.zjmeow.bubble.model.po;

import lombok.Data;

import java.util.Date;

/**
 * @description: 评论PO
 * @author: zjm
 **/

@Data
public class Comment {
    private Date createdTime;
    private String avatar;
    private int id;
    private int bubbleId;
    private int userId;
    private int tap;
    private String content;

}
