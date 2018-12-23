package com.zjmeow.bubble.dao;

import com.zjmeow.bubble.model.po.Comment;

import java.util.List;

/**
 * @description: 评论mapper
 * @author: zjm
 **/


public interface CommentMapper {
    List<Comment> selectCommentByBubble(Integer bubbleId);

}
