package com.zjmeow.bubble.dao;

import com.zjmeow.bubble.model.po.Bubble;

import java.util.List;

public interface BubbleMapper {


    int insert(Bubble record);

    Bubble selectBubbleById(Integer id);

    List<Bubble> selectBubbleByLocation(String point);

    List<Bubble> selectBubbleByUserId(Integer userId);
}