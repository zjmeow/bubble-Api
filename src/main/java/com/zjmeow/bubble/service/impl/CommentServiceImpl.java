package com.zjmeow.bubble.service.impl;

import com.zjmeow.bubble.dao.CommentMapper;
import com.zjmeow.bubble.model.dto.CommentDTO;
import com.zjmeow.bubble.model.po.Comment;
import com.zjmeow.bubble.model.vo.CommentVO;
import com.zjmeow.bubble.service.CommentService;
import com.zjmeow.bubble.util.JWTUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 评论服务层实现
 * @author: zjm
 **/

@Service
public class CommentServiceImpl implements CommentService {
    private final ModelMapper modelMapper;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(ModelMapper modelMapper,
                              CommentMapper commentMapper) {
        this.modelMapper = modelMapper;
        this.commentMapper = commentMapper;
    }

    @Override
    public void comment(CommentDTO commentDTO) {
        Comment comment = modelMapper.map(commentDTO, Comment.class);
        Integer userId = JWTUtil.getCurrentUserId();
        comment.setUserId(userId);
        commentMapper.insertComment(comment);
    }


    @Override
    public List<CommentVO> selectCommentByBubble(Integer id) {
        List<Comment> comments = commentMapper.selectCommentByBubble(id);
        return modelMapper.map(comments, new TypeToken<List<CommentVO>>() {
        }.getType());
    }
}
