package com.zjmeow.bubble.service;

import com.zjmeow.bubble.model.dto.CommentDTO;
import com.zjmeow.bubble.model.vo.CommentVO;

import java.util.List;

/**
 * @description: bubble评论服务层
 * @author: zjm
 **/


public interface CommentService {
    /**
     * @param commentDTO
     * @description: 评论bubble
     */
    void comment(CommentDTO commentDTO);

    /**
     * @param id bubble 的 id
     * @return : List<CommentVO>
     * @description: 通过 bubble 的 id 来查找评论
     */
    List<CommentVO> selectCommentByBubble(Integer id);
}
