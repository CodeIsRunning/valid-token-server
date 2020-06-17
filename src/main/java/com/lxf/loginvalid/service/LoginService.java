package com.lxf.loginvalid.service;

import com.lxf.loginvalid.dto.LoginReq;
import com.lxf.loginvalid.dto.LoginRes;
import com.lxf.loginvalid.exception.BusinessException;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/6/17 16:20
 */
public interface LoginService {

    /**
     * 登录
     * @param loginReq
     * @return
     */
   LoginRes login(LoginReq loginReq)throws BusinessException;

    /**
     * 测试
     * @return
     */
   String test();

}
