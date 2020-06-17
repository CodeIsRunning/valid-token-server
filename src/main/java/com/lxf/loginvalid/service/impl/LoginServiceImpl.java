package com.lxf.loginvalid.service.impl;

import com.lxf.loginvalid.dto.LoginReq;
import com.lxf.loginvalid.dto.LoginRes;
import com.lxf.loginvalid.exception.BusinessException;
import com.lxf.loginvalid.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/6/17 16:21
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Override
    public LoginRes login(LoginReq loginReq) throws BusinessException {
        LoginRes loginRes = new LoginRes();


        // TODO: 2020/6/17 查询用户名密码校验

        if (!loginReq.getUserName().equals("admin") || !loginReq.getPassword().equals("admin")) {
            throw new BusinessException("9999", "未找到用户或用户名密码错误");
        }

        /**
         * 用户id
         */
        Integer id = 1;


        //单点登录
        String oldToken = stringRedisTemplate.opsForValue().get(loginReq.getUserName() + loginReq.getPassword());

        if (!StringUtils.isBlank(oldToken)) {
            stringRedisTemplate.delete(oldToken);
            stringRedisTemplate.delete(loginReq.getUserName() + loginReq.getPassword());
        }


        String token = UUID.randomUUID().toString().replaceAll("-", "");

        stringRedisTemplate.opsForValue().set(token, String.valueOf(id), 5 * 60 * 1000, TimeUnit.MILLISECONDS);

        stringRedisTemplate.opsForValue().set(loginReq.getUserName() + loginReq.getPassword(), token);

        loginRes.setUserName(loginReq.getUserName());
        loginRes.setPhone("xxx");
        loginRes.setToken(token);
        loginRes.setId(id);

        return loginRes;
    }

    @Override
    public String test() {
        return null;
    }
}
