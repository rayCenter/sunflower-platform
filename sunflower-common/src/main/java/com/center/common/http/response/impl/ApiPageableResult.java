package com.center.common.http.response.impl;

import com.center.common.http.response.ResponseResult;
import lombok.Data;

import java.io.Serializable;

@Data
public class ApiPageableResult<T> implements ResponseResult<T>, Serializable {

    /* 响应总数 */
    private long total;

    /* 响应列表 */
    private T list;

    private ApiPageableResult(final long total, final T list) {
        this.total = total;
        this.list = list;
    }

    private static <T> ApiPageableResult<T> response(final long total, final T list) {
        return new ApiPageableResult<>(total, list);
    }

    public static <T> ApiPageableResult<T> failed(final long total, final T list) {
        return response(total, list);
    }

    public static <T> ApiPageableResult<T> succeeded(final long total, final T list) {
        return response(total, list);
    }

}
