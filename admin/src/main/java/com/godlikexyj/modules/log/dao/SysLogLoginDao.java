package com.godlikexyj.modules.log.dao;

import com.godlikexyj.common.dao.BaseDao;
import com.godlikexyj.modules.log.entity.SysLogLoginEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 登录日志
 *
 * @author xyj godlikexyj@gmail.com
 * @since 1.0.0
 */
@Mapper
public interface SysLogLoginDao extends BaseDao<SysLogLoginEntity> {
	
}
