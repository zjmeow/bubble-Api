package com.zjmeow.bubble.model.dto;

import lombok.Data;

/**
 * @description: 用户地理位置信息上传
 * @author: zjm
 **/

@Data
public class LocationDTO {
    private Double lat;
    private Double lng;
}
