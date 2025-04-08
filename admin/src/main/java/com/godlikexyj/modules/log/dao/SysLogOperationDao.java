package com.godlikexyj.modules.log.dao;

import com.godlikexyj.common.dao.BaseDao;
import com.godlikexyj.modules.log.entity.SysLogOperationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 操作日志
 *
 * @author xyj godlikeyxj@gmail.com
 * @since 1.0.0
 */
@Mapper
public interface SysLogOperationDao extends BaseDao<SysLogOperationEntity> {
	
}
