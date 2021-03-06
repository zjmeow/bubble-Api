package com.zjmeow.bubble.service.impl;

import com.zjmeow.bubble.dao.BubbleMapper;
import com.zjmeow.bubble.dao.CounterMapper;
import com.zjmeow.bubble.dao.UserMapper;
import com.zjmeow.bubble.exception.ResourceNotFoundException;
import com.zjmeow.bubble.model.dto.BubbleDTO;
import com.zjmeow.bubble.model.po.Bubble;
import com.zjmeow.bubble.model.po.User;
import com.zjmeow.bubble.model.vo.BubbleDetailVO;
import com.zjmeow.bubble.model.vo.BubbleListVO;
import com.zjmeow.bubble.model.vo.BubbleMapVO;
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
    private final UserMapper userMapper;
    private final CounterMapper counterMapper;

    @Autowired
    public BubbleServiceImpl(ModelMapper modelMapper,
                             BubbleMapper bubbleMapper,
                             UserMapper userMapper,
                             CounterMapper counterMapper) {
        this.modelMapper = modelMapper;
        this.bubbleMapper = bubbleMapper;
        this.userMapper = userMapper;
        this.counterMapper = counterMapper;
    }

    @Override
    public void uploadBubble(BubbleDTO bubbleDTO) {
        Bubble bubble = modelMapper.map(bubbleDTO, Bubble.class);
        // 通过字符串拼接生成POINT，进而查找
        bubble.setPoint("POINT(" + bubble.getLng() + " " + bubble.getLat() + ")");
        bubble.setUserId(JWTUtil.getCurrentUserId());
        bubbleMapper.insert(bubble);
        counterMapper.insertCounter(bubble.getId());
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

        BubbleDetailVO bubbleDetailVO = modelMapper.map(bubble, BubbleDetailVO.class);
        User user = userMapper.selectUserDetailById(bubble.getUserId());
        bubbleDetailVO.setAvatar(user.getAvatar());
        bubbleDetailVO.setUsername(user.getUsername());
        return bubbleDetailVO;
    }

    @Override
    public List<BubbleListVO> selectBubbleByUserId(Integer userId) {
        List<Bubble> bubbles = bubbleMapper.selectBubbleByUserId(userId);
        List<BubbleListVO> bubbleListVOS = modelMapper.map(bubbles, new TypeToken<List<BubbleListVO>>() {
        }.getType());
        for (BubbleListVO bubble : bubbleListVOS) {
            bubble.setCommentNum(counterMapper.selectCounter(bubble.getId()).getCommentNum());
        }
        return bubbleListVOS;
    }

    @Override
    public void addOneTap(Integer bubbleId) {
        bubbleMapper.addOneTap(bubbleId);
    }
}
