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
    /**
     * @param bubbleDTO
     * @description: 用户发布bubble
     */
    void uploadBubble(BubbleDTO bubbleDTO);

    /**
     * @param id bubble 的id
     * @return com.zjmeow.bubble.model.vo.BubbleDetailVO
     * @description: 通过 id 获取 bubble 详情
     */
    BubbleDetailVO getBubbleDetail(Integer id);

    /**
     * @param lng
     * @param lat
     * @return : List<BubbleMapVO>
     * @description: 通过用户的位置查找附近的用户
     */
    List<BubbleMapVO> selectBubbleByLocation(Double lng, Double lat);

    /**
     * @param userId
     * @return : List<BubbleListVO> 用户列表的VO
     * @description: 通过用户的 id 查找用户所发布的全部 bubble
     */

    List<BubbleListVO> selectBubbleByUserId(Integer userId);

    /**
     * @param bubbleId
     * @description: 给 bubble 点赞
     */
    void addOneTap(Integer bubbleId);

}
