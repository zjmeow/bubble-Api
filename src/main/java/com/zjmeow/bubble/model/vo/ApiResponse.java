package com.zjmeow.bubble.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    /* 不提供直接设置errorCode的接口，只能通过setErrorInfo方法设置错误信息 */
    private String errorCode;

    private ApiResponse() {
    }

    public static <T> ApiResponse<T> newInstance() {
        return new ApiResponse<>();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


}
