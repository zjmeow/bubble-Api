package com.zjmeow.bubble.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: 发表评论
 * @author: zjm
 **/


@Data
public class CommentDTO {
    @NotNull
    private Integer bubbleId;
    @NotNull
    private String content;
}
