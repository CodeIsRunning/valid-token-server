package com.lxf.loginvalid.controller;

import com.lxf.loginvalid.annotation.ValidToken;
import com.lxf.loginvalid.common.ResultCommon;
import com.lxf.loginvalid.dto.LoginReq;
import com.lxf.loginvalid.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/6/17 16:20
 */
@Slf4j
@RestController
@RequestMapping
public class LoginController extends AbstractController{


    @Resource
    LoginService loginService;

    @RequestMapping("login")
    public ResultCommon login(@RequestBody LoginReq loginReq)throws Exception{
       return ResultCommon.successfulResult(loginService.login(loginReq));
    }

    @ValidToken
    @RequestMapping("test")
    public ResultCommon test()throws Exception{
        log.info("用户id"+getUserId());
        return ResultCommon.successfulResult(loginService.test());
    }

}
