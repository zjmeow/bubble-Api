package com.zjmeow.bubble.dao;

import com.zjmeow.bubble.model.po.Counter;

/**
 * @description: bubble评论计数表，分出counter表优化计数查询
 * @author: zjm
 **/


public interface CounterMapper {
    void addCounter(Integer bubbleId);

    void insertCounter(Integer bubbleId);

    Counter selectCounter(Integer bubbleId);
}
