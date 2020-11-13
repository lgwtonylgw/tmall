package com.tony.tmall.common.exception;


import com.tony.tmall.common.model.enums.ResultCode;

/**
 * 自定义API异常
 * Created by tony on 2020/2/27.
 */
public class ApiException extends RuntimeException {
    private ResultCode errorCode;

    public ApiException(ResultCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResultCode getErrorCode() {
        return errorCode;
    }
}
