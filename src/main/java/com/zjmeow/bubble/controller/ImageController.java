package com.zjmeow.bubble.controller;

import com.zjmeow.bubble.model.vo.ApiResponse;
import com.zjmeow.bubble.model.vo.ImageVO;
import com.zjmeow.bubble.service.ImageService;
import com.zjmeow.bubble.util.RestResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 上传图片使用
 * @author: zjm
 **/

@RestController
@RequestMapping(value = "/images")
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }


    @ApiOperation(value = "时光发布", notes = "发布完成后将获取OOS凭证,进一步上传时光图片")
    @GetMapping("/upload")
    public ApiResponse<ImageVO> upload() {
        return RestResultGenerator.genResult(imageService.upload(), "ok");
    }


}
