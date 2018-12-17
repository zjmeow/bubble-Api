package com.zjmeow.bubble.util;


import com.zjmeow.bubble.enums.ResponseErrorEnum;
import com.zjmeow.bubble.model.vo.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestResultGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestResultGenerator.class);

    public static <T> ApiResponse<T> genResult(T data, String message) {
        ApiResponse<T> result = ApiResponse.newInstance();
        result.setSuccess(true);
        result.setData(data);
        result.setMessage(message);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("--------> result:{}");
        }
        return result;
    }

    public static ApiResponse genErrorResult(ResponseErrorEnum responseErrorEnum) {
        ApiResponse result = ApiResponse.newInstance();
        result.setSuccess(false);
        result.setErrorCode(responseErrorEnum.getMessage());
        if (LOGGER.isDebugEnabled()) {

        }

        return result;
    }

}
