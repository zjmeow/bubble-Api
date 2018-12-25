package com.zjmeow.bubble.exception;


import com.zjmeow.bubble.enums.ResponseErrorEnum;
import com.zjmeow.bubble.model.vo.ApiResponse;
import com.zjmeow.bubble.util.RestResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.UnexpectedTypeException;

/**
 * @description: 错误统一处理
 * @author: zjm
 **/

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    /**
     * bean校验未通过异常
     *
     * @see javax.validation.Valid
     * @see org.springframework.validation.Validator
     * @see org.springframework.validation.DataBinder
     */
    @ExceptionHandler(UnexpectedTypeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private <T> ApiResponse<T> illegalParamsExceptionHandler(UnexpectedTypeException e) {
        log.error("--------->请求参数不合法!", e);
        return RestResultGenerator.genErrorResult(ResponseErrorEnum.ILLEGAL_PARAMS);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public <T> ApiResponse<T> jsonErrorHandler(Exception e) throws Exception {
        log.error("--------->请求参数不合法!", e);
        return RestResultGenerator.genErrorResult(ResponseErrorEnum.ILLEGAL_PARAMS);
    }
}
