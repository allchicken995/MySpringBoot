package com.godlikexyj.common.annotation;

import java.lang.annotation.*;

/**
 * 启用外键关联操作
 *
 * @author xyj godlikexyj@gmail.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ForeignKey {
	
}
