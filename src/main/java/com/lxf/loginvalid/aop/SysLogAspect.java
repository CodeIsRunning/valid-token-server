package com.lxf.loginvalid.aop;

import com.lxf.loginvalid.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 系统日志，切面处理类
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017年3月8日 上午11:07:35
 */
@Aspect
@Component
@Slf4j
public class SysLogAspect {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("@annotation(com.lxf.loginvalid.annotation.ValidToken)")
    public void logPointCut() {

    }

    /**
     * 切入通知
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {


        //获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();


        String token = request.getHeader("token");


        if (StringUtils.isBlank(token)) {
            throw new BusinessException("9999", "请重新登录");
        }

        String userId = stringRedisTemplate.opsForValue().get(token);

        if (StringUtils.isBlank(userId)) {
            throw new BusinessException("9999", "请重新登录");
        }

        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)

        return result;
    }
}
