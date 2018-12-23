package com.zjmeow.bubble.service;

import com.zjmeow.bubble.model.dto.CommentDTO;
import com.zjmeow.bubble.model.vo.CommentVO;

import java.util.List;

/**
 * @description: bubble评论服务层
 * @author: zjm
 **/


public interface CommentService {
    void comment(CommentDTO commentDTO);

    List<CommentVO> selectCommentByBubble(Integer id);
}
