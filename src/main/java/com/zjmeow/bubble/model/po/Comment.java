package com.zjmeow.bubble.model.po;

import lombok.Data;

/**
 * @description: 评论PO
 * @author: zjm
 **/

@Data
public class Comment {
    private String avatar;
    private int id;
    private int bubbleId;
    private int userId;
    private int tap;
    private String content;

}
