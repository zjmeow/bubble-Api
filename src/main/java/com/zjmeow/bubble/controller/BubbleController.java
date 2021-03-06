package com.zjmeow.bubble.controller;

import com.zjmeow.bubble.model.dto.BubbleDTO;
import com.zjmeow.bubble.model.dto.TapBubbleDTO;
import com.zjmeow.bubble.model.vo.ApiResponse;
import com.zjmeow.bubble.model.vo.BubbleDetailVO;
import com.zjmeow.bubble.model.vo.BubbleListVO;
import com.zjmeow.bubble.model.vo.BubbleMapVO;
import com.zjmeow.bubble.service.BubbleService;
import com.zjmeow.bubble.util.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @description: 地图上的 bubble 控制器
 * @author: zjm
 **/
@Validated
@RequestMapping(value = "/bubbles")
@RestController
public class BubbleController {
    private final BubbleService bubbleService;

    @Autowired
    public BubbleController(BubbleService bubbleService) {
        this.bubbleService = bubbleService;
    }

    @PostMapping("/upload")
    ApiResponse<String> uploadBubble(@Valid BubbleDTO bubbleDTO) {
        bubbleService.uploadBubble(bubbleDTO);
        return RestResultGenerator.genResult("上传成功", "ok");
    }

    @GetMapping("/detail")
    ApiResponse<BubbleDetailVO> bubbleDetail(Integer id) {
        BubbleDetailVO bubbleDetailVO = bubbleService.getBubbleDetail(id);
        return RestResultGenerator.genResult(bubbleDetailVO, "ok");
    }


    @GetMapping("/around")
    ApiResponse<List<BubbleMapVO>> aroundBubble(Double lng, Double lat) {
        List<BubbleMapVO> bubbleMapVOS = bubbleService.selectBubbleByLocation(lng, lat);
        return RestResultGenerator.genResult(bubbleMapVOS, "ok");
    }


    @GetMapping("/user")
    ApiResponse<List<BubbleListVO>> getBubbleByUserId(Integer userId) {
        List<BubbleListVO> bubbleListVOS = bubbleService.selectBubbleByUserId(userId);
        return RestResultGenerator.genResult(bubbleListVOS, "ok");
    }


    @PostMapping("/tap")
    ApiResponse<String> tap(TapBubbleDTO tapBubbleDTO) {
        bubbleService.addOneTap(tapBubbleDTO.getId());
        return RestResultGenerator.genResult("点赞成功", "ok");
    }

}
