package com.zjmeow.bubble.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @description: token认证失败
 * @author: zjm
 **/

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "token认证失败")
public class TokenException extends RuntimeException {
}
