package com.godlikexyj.common.annotation;

import java.lang.annotation.*;

/**
 * 外键注解
 *
 * @author xyj godlikexyj@gmail.com
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ForeignKeyField {
	 /**
	 * 处理方式
	 */
	String[] handle() default "";
}
