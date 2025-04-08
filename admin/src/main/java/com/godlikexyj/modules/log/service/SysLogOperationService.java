package com.godlikexyj.modules.log.service;

import com.godlikexyj.common.page.PageData;
import com.godlikexyj.common.service.BaseService;
import com.godlikexyj.modules.log.dto.SysLogOperationDto;
import com.godlikexyj.modules.log.entity.SysLogOperationEntity;

import java.util.List;
import java.util.Map;

/**
 * 操作日志
 *
 * @author xyj godlikexyj@gmail.com
 * @since 1.0.0
 */
public interface SysLogOperationService extends BaseService<SysLogOperationEntity> {

    PageData<SysLogOperationDto> page(Map<String, Object> params);

    List<SysLogOperationDto> list(Map<String, Object> params);

    void save(SysLogOperationEntity entity);
}