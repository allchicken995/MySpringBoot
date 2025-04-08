package com.godlikexyj.common.annotation;

import java.lang.annotation.*;

/**
 * 操作日志注解
 *
 * @author xyj godlikexyj@gmail.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogOperation {
	/**
     * 操作备注
     */
	String value() default "";
}
