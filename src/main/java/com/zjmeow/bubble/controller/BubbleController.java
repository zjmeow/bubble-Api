package com.zjmeow.bubble.controller;

import com.zjmeow.bubble.model.dto.BubbleDTO;
import com.zjmeow.bubble.model.vo.ApiResponse;
import com.zjmeow.bubble.model.vo.BubbleDetailVO;
import com.zjmeow.bubble.model.vo.BubbleMapVO;
import com.zjmeow.bubble.service.BubbleService;
import com.zjmeow.bubble.util.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 地图上的 bubble 控制器
 * @author: zjm
 **/

@RestController
public class BubbleController {
    private final BubbleService bubbleService;

    @Autowired
    public BubbleController(BubbleService bubbleService) {
        this.bubbleService = bubbleService;
    }

    @PostMapping("/bubble")
    ApiResponse<String> uploadBubble(BubbleDTO bubbleDTO) {
        bubbleService.uploadBubble(bubbleDTO);
        return RestResultGenerator.genResult("上传成功", "ok");
    }

    @GetMapping("/bubble/detail")
    ApiResponse<BubbleDetailVO> bubbleDetail(Integer id) {
        BubbleDetailVO bubbleDetailVO = bubbleService.getBubbleDetail(id);
        return RestResultGenerator.genResult(bubbleDetailVO, "ok");
    }


    @GetMapping("/bubble/around")
    ApiResponse<List<BubbleMapVO>> aroundBubble(Double lng, Double lat) {
        List<BubbleMapVO> bubbleMapVOS = bubbleService.selectBubbleByLocation(lng, lat);
        return RestResultGenerator.genResult(bubbleMapVOS, "ok");
    }

}
