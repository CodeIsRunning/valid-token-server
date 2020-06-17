package com.lxf.loginvalid.common;

import lombok.Data;

/**
 * 统一返回
 *
 * @author lxf
 */
@Data
public class ResultCommon {

    private String retCode;
    private String retMsg;
    private Object data;

    public ResultCommon() {
    }

    public ResultCommon(String retCode, String retMsg, Object data) {
        super();
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.data = data;
    }

    public static ResultCommon successfulResult(Object data) {
        return new ResultCommon(Constans.SUCCESS_CODE, Constans.SUCCESS_MESSAGE, data);
    }

    public static ResultCommon failResult() {
        return new ResultCommon(Constans.SYSTEM_ERROR_CODE, Constans.SYSTEM_ERROR_MESSAGE, "");
    }

}
