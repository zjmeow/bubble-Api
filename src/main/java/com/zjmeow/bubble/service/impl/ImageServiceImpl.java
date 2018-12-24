package com.zjmeow.bubble.service.impl;

import com.qiniu.util.Auth;
import com.zjmeow.bubble.model.vo.ImageVO;
import com.zjmeow.bubble.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @description:七牛上传图片
 * @author: zjm
 **/

@Service
public class ImageServiceImpl implements ImageService {
    private final String accessKey = "zfTdGi-7kuIP0YH-FxFodCzd87-yBYg8io5z88VR";
    private final String secretKey = "HZ0aVM3_RwTYKlbJLshhWetbcgDJz9ApI8PoHw3r";
    private final String bucket = "bubble";

    @Override
    public ImageVO upload() {
        Auth auth = Auth.create(accessKey, secretKey);
        String fileName = UUID.randomUUID().toString();
        String upToken = auth.uploadToken(bucket, fileName);
        ImageVO imageVO = new ImageVO();
        imageVO.setImageName(fileName);
        imageVO.setToken(upToken);
        return imageVO;
    }


}
