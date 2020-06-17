package com.lxf.loginvalid.controller;


import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Controller公共组件
 * 
 * @date 2017年11月9日 下午9:42:26
 */
@Component
public class AbstractController {

	@Resource
    StringRedisTemplate stringRedisTemplate;



	public Integer getUserId() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String token =  request.getHeader("token");
		String userId = stringRedisTemplate.opsForValue().get(token);
		return Integer.valueOf(userId);
	}


}
