package com.lxf.loginvalid.adv;

import com.lxf.loginvalid.common.ResultCommon;
import com.lxf.loginvalid.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常监测
 *
 * @author liuxf
 */
@Slf4j
@RestControllerAdvice
public class AdvControllerAdvice {


    @ExceptionHandler(value = BusinessException.class)
    public ResultCommon BusinessExceptionHandler(BusinessException ex) {

        log.error(ExceptionUtils.getStackTrace(ex));
        return new ResultCommon(ex.getCode(), ex.getMsg(), "");

    }

    @ExceptionHandler(value = Exception.class)
    public ResultCommon ExceptionHandler(Exception ex) {

        log.error(ExceptionUtils.getStackTrace(ex));
        return ResultCommon.failResult();

    }

}
