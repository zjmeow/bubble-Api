package com.zjmeow.bubble.service;

import com.zjmeow.bubble.model.vo.ImageVO;

/**
 * @description: 七牛上传图片
 * @author: zjm
 **/


public interface ImageService {
    /**
     * @return : ImageVO  图片随机生成的名字和上传凭证
     * @description: 上传图片前需要调用这个接口拿到凭证才能上传
     */
    ImageVO upload();

}
