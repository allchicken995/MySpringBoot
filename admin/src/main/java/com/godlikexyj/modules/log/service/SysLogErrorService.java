package com.godlikexyj.modules.log.service;


import com.godlikexyj.common.page.PageData;
import com.godlikexyj.common.service.BaseService;
import com.godlikexyj.modules.log.dto.SysLogErrorDto;
import com.godlikexyj.modules.log.entity.SysLogErrorEntity;

import java.util.List;
import java.util.Map;

/**
 * 异常日志
 *
 * @author xyj godlikexyj@gmail.com
 * @since 1.0.0
 */
public interface SysLogErrorService extends BaseService<SysLogErrorEntity> {

    PageData<SysLogErrorDto> page(Map<String, Object> params);

    List<SysLogErrorDto> list(Map<String, Object> params);

    void save(SysLogErrorEntity entity);

}