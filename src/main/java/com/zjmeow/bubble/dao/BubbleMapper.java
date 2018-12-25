package com.zjmeow.bubble.dao;

import com.zjmeow.bubble.model.po.Bubble;

import java.util.List;

/**
 * @description: 地图上的分享内容 DAO 层
 * @author: zjm
 **/
public interface BubbleMapper {


    int insert(Bubble record);

    Bubble selectBubbleById(Integer id);

    List<Bubble> selectBubbleByLocation(String point);

    List<Bubble> selectBubbleByUserId(Integer userId);

    int addOneTap(Integer bubbleId);
}