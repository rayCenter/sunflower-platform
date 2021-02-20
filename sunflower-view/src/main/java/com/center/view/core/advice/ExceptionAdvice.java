package com.center.view.core.advice;

import com.center.common.ConstantEnum;
import com.center.common.error.AssertUtils;
import com.center.common.error.BusinessException;
import com.center.common.http.response.ResponseResult;
import com.center.common.http.response.impl.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@ControllerAdvice(annotations = {Controller.class, RestController.class})
public class ExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    /*@ResponseStatus(HttpStatus.BAD_REQUEST)*/
    @ResponseBody
    public ResponseResult<String> handle(BusinessException businessException) {
        log.error("业务处理异常：[{}]", businessException.getMessage());
        return ApiResult.failed(
                ConstantEnum.Status.FAILED.getCode(),
                String.format("业务处理异常：[%s]", businessException.getMessage())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    /*@ResponseStatus(HttpStatus.BAD_REQUEST)*/
    @ResponseBody
    public ResponseResult<String> handle(MethodArgumentNotValidException methodArgumentNotValidException) {
        FieldError fieldError = methodArgumentNotValidException.getBindingResult().getFieldError();
        AssertUtils.isNotEmpty(fieldError, "参数校验异常");
        String field = fieldError.getField();
        AssertUtils.isNotBlank(field, "参数校验字段空");
        log.error("参数校验异常：[{} - {}]", field, fieldError.getDefaultMessage());
        return ApiResult.failed(
                ConstantEnum.Status.FAILED.getCode(),
                String.format("参数校验异常：[%s - %s]", field, fieldError.getDefaultMessage())
        );
    }
}
