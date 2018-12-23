package com.zjmeow.bubble.service.impl;

import com.zjmeow.bubble.dao.BubbleMapper;
import com.zjmeow.bubble.dao.CommentMapper;
import com.zjmeow.bubble.exception.ResourceNotFoundException;
import com.zjmeow.bubble.model.dto.BubbleDTO;
import com.zjmeow.bubble.model.po.Bubble;
import com.zjmeow.bubble.model.po.Comment;
import com.zjmeow.bubble.model.vo.BubbleDetailVO;
import com.zjmeow.bubble.model.vo.BubbleMapVO;
import com.zjmeow.bubble.model.vo.CommentVO;
import com.zjmeow.bubble.service.BubbleService;
import com.zjmeow.bubble.util.JWTUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zjm
 **/

@Service
public class BubbleServiceImpl implements BubbleService {
    private final ModelMapper modelMapper;
    private final BubbleMapper bubbleMapper;
    private final CommentMapper commentMapper;

    @Autowired
    public BubbleServiceImpl(ModelMapper modelMapper,
                             BubbleMapper bubbleMapper,
                             CommentMapper commentMapper) {
        this.modelMapper = modelMapper;
        this.bubbleMapper = bubbleMapper;
        this.commentMapper = commentMapper;
    }

    @Override
    public void uploadBubble(BubbleDTO bubbleDTO) {
        Bubble bubble = modelMapper.map(bubbleDTO, Bubble.class);
        bubble.setPoint("POINT(" + bubble.getLng() + " " + bubble.getLat() + ")");
        bubble.setUserId(JWTUtil.getCurrentUserId());
        bubbleMapper.insert(bubble);
    }


    @Override
    public List<BubbleMapVO> selectBubbleByLocation(Double lng, Double lat) {
        String point = "location<-> SRID=4326;POINT(" + lng + " " + lat + ")::geometry";
        List<Bubble> bubbles = bubbleMapper.selectBubbleByLocation(point);
        return modelMapper.map(bubbles, new TypeToken<List<BubbleMapVO>>() {
        }.getType());
    }

    @Override
    public BubbleDetailVO getBubbleDetail(Integer id) {
        Bubble bubble = bubbleMapper.selectBubbleById(id);
        if (bubble == null) {
            throw new ResourceNotFoundException();
        }
        List<Comment> comments = commentMapper.selectCommentByBubble(id);
        BubbleDetailVO bubbleDetailVO = modelMapper.map(bubble, BubbleDetailVO.class);
        List<CommentVO> commentVOS = modelMapper.map(comments, new TypeToken<List<CommentVO>>() {
        }.getType());
        bubbleDetailVO.setComments(commentVOS);
        return bubbleDetailVO;
    }
}
