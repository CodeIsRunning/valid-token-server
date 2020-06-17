package com.lxf.loginvalid.annotation;

import java.lang.annotation.*;

/**
 * token校验
 * 
 * @author liuxf
 * @date 2017年3月8日 上午10:19:56
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidToken {
	/**
	 * 角色保留
	 * @return
	 */
	String value() default "";
}
