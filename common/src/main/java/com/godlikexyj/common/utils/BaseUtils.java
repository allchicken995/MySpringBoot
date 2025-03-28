package com.godlikexyj.common.utils;

import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 基础工具类
 *
 * @author xyj godlikexyj@gmail.com
 */
public class BaseUtils {
	
	public static String getUuid(){
		return UUID.randomUUID().toString();
	}
	
	public static boolean isNumeric(String str) {
		if(str==null) {
			return false;
		}else {
			Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
		    return pattern.matcher(str).matches();
		}
    }
}
