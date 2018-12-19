package com.zjmeow.bubble.model.mapper;

import com.zjmeow.bubble.model.po.Bubble;
import com.zjmeow.bubble.model.po.BubbleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BubbleMapper {
    long countByExample(BubbleExample example);

    int deleteByExample(BubbleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bubble record);

    int insertSelective(Bubble record);

    List<Bubble> selectByExample(BubbleExample example);

    Bubble selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bubble record, @Param("example") BubbleExample example);

    int updateByExample(@Param("record") Bubble record, @Param("example") BubbleExample example);

    int updateByPrimaryKeySelective(Bubble record);

    int updateByPrimaryKey(Bubble record);
}