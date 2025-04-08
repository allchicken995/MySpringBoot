package com.godlikexyj.modules.log.dao;

import com.godlikexyj.common.dao.BaseDao;
import com.godlikexyj.modules.log.entity.SysLogErrorEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 异常日志
 *
 * @author xyj godlikexyj@gmail.com
 * @since 1.0.0
 */
@Mapper
public interface SysLogErrorDao extends BaseDao<SysLogErrorEntity> {
	
}
