package com.zjmeow.bubble.service.impl;

import com.zjmeow.bubble.dao.BubbleMapper;
import com.zjmeow.bubble.model.dto.BubbleDTO;
import com.zjmeow.bubble.model.po.Bubble;
import com.zjmeow.bubble.service.BubbleService;
import com.zjmeow.bubble.util.JWTUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zjm
 **/

@Service
public class BubbleServiceImpl implements BubbleService {
    private final ModelMapper modelMapper;
    private final BubbleMapper bubbleMapper;

    @Autowired
    public BubbleServiceImpl(ModelMapper modelMapper,
                             BubbleMapper bubbleMapper) {
        this.modelMapper = modelMapper;
        this.bubbleMapper = bubbleMapper;
    }

    @Override
    public void uploadBubble(BubbleDTO bubbleDTO) {
        Bubble bubble = modelMapper.map(bubbleDTO, Bubble.class);
        bubble.setPoint("POINT(" + bubble.getLng() + " " + bubble.getLat() + ")");
        bubble.setUserId(JWTUtil.getCurrentUserId());
        bubbleMapper.insert(bubble);
    }
}
