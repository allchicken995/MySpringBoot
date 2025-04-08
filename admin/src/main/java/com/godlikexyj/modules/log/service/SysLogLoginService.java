package com.godlikexyj.modules.log.service;

import com.godlikexyj.common.page.PageData;
import com.godlikexyj.common.service.BaseService;
import com.godlikexyj.modules.log.dto.SysLogLoginDto;
import com.godlikexyj.modules.log.entity.SysLogLoginEntity;

import java.util.List;
import java.util.Map;

/**
 * 登录日志
 *
 * @author xyj godlikexyj@gmail.com
 * @since 1.0.0
 */
public interface SysLogLoginService extends BaseService<SysLogLoginEntity> {

    PageData<SysLogLoginDto> page(Map<String, Object> params);

    List<SysLogLoginDto> list(Map<String, Object> params);

    void save(SysLogLoginDto dto);
}