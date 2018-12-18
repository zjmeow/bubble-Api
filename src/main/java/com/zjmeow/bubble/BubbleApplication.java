package com.zjmeow.bubble;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zjmeow.bubble.dao") // mybatis扫描路径，针对的是接口Mapper类
@SpringBootApplication
public class BubbleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BubbleApplication.class, args);
    }
}
