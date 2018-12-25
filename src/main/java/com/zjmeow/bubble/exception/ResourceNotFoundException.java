package com.zjmeow.bubble.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @description: 请求了不存在的资源会抛出这个错误，比如请求了id为10的信息，但是数据库没有这条信息
 * @author: zjm
 **/

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "not found")
public class ResourceNotFoundException extends RuntimeException {


}
