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
    private Integer id;
    private Integer bubbleId;
    private Integer userId;
    private Integer tap;
    private String content;
    private String username;

}
