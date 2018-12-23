package com.zjmeow.bubble.model.dto;

import lombok.Data;

/**
 * @description: 发表评论
 * @author: zjm
 **/


@Data
public class CommentDTO {
    private int bubbleId;
    private String content;
}
