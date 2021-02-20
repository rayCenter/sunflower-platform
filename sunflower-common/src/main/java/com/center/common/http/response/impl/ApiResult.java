package com.center.common.http.response.impl;

import com.center.common.http.response.ResponseResult;
import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResult<T> implements ResponseResult<T>, Serializable {

    /* 响应码 */
    private int code;

    /* 响应信息 */
    private String info;

    /* 响应数据 */
    private T data;

    private ApiResult(final int code) {
        this.code = code;
    }

    private ApiResult(final int code, final String info) {
        this.code = code;
        this.info = info;
    }

    private ApiResult(final int code, final String info, final T data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }

    private static <T> ApiResult<T> response(final int code) {
        return new ApiResult<>(code);
    }

    private static <T> ApiResult<T> response(final int code, final String info) {
        return new ApiResult<>(code, info);
    }

    private static <T> ApiResult<T> response(final int code, final String info, final T data) {
        return new ApiResult<>(code, info, data);
    }

    public static <T> ApiResult<T> failed(final int code) {
        return response(code);
    }

    public static <T> ApiResult<T> failed(final int code, final String info) {
        return response(code, info);
    }

    public static <T> ApiResult<T> failed(final int code, final String info, final T data) {
        return response(code, info, data);
    }

    public static <T> ApiResult<T> succeeded(final int code) {
        return response(code);
    }

    public static <T> ApiResult<T> succeeded(final int code, final String info) {
        return response(code, info);
    }

    public static <T> ApiResult<T> succeeded(final int code, final String info, final T data) {
        return response(code, info, data);
    }

}
