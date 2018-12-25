package com.zjmeow.bubble.service;

import com.zjmeow.bubble.model.dto.BubbleDTO;
import com.zjmeow.bubble.model.vo.BubbleDetailVO;
import com.zjmeow.bubble.model.vo.BubbleListVO;
import com.zjmeow.bubble.model.vo.BubbleMapVO;

import java.util.List;

/**
 * @description: 地图分享
 * @author: zjm
 **/


public interface BubbleService {
    void uploadBubble(BubbleDTO bubbleDTO);

    BubbleDetailVO getBubbleDetail(Integer id);

    List<BubbleMapVO> selectBubbleByLocation(Double lng, Double lat);

    List<BubbleListVO> selectBubbleByUserId(Integer userId);

    void addOneTap(Integer bubbleId);

}
