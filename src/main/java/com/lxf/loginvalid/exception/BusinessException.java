package com.lxf.loginvalid.exception;


import java.io.Serializable;


/**
 * @author lxf
 * 自定义异常类
 */
public class BusinessException extends Exception implements Serializable {

    private static final long serialVersionUID = -6695600119719221177L;
    private String code;
    private String msg;
    private Object data;

    public BusinessException() {
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String errorCode, String message) {
        super(message);
        this.msg = message;
        this.code = errorCode;
    }

    public BusinessException(String errorCode, String message, Object[] args) {
        super(String.format(message, args));
        this.code = errorCode;
        this.msg = message;
    }

    public BusinessException(String errorCode, String message, Object args) {
        super(String.format(message, args));
        this.code = errorCode;
        this.msg = message;
        this.data = args;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
