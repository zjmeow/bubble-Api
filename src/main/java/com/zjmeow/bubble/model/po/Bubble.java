package com.zjmeow.bubble.model.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 */
@Data
public class Bubble implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Double lat;
    private Double lng;
    private String title;
    private String content;
    private String pic;
    private Integer userId;
    private Date createdTime;
    private Boolean visible;
    private Integer tap;
    private Date deadline;
    private String point;

}