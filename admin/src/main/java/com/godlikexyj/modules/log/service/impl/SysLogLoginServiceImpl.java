package com.godlikexyj.modules.log.service.impl;

import com.godlikexyj.common.page.PageData;
import com.godlikexyj.common.service.impl.BaseServiceImpl;
import com.godlikexyj.common.utils.ConvertUtils;
import com.godlikexyj.modules.log.dao.SysLogLoginDao;
import com.godlikexyj.modules.log.dto.SysLogLoginDto;
import com.godlikexyj.modules.log.entity.SysLogLoginEntity;
import com.godlikexyj.modules.log.service.SysLogLoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 登录日志
 *
 * @author xyj godlikexyj@gmail.com
 * @since 1.0.0
 */
@Service
public class SysLogLoginServiceImpl extends BaseServiceImpl<SysLogLoginDao, SysLogLoginEntity> implements SysLogLoginService {

    @Override
    public PageData<SysLogLoginDto> page(Map<String, Object> params) {
        return getPage(params,SysLogLoginDto.class);
    }

    @Override
    public List<SysLogLoginDto> list(Map<String, Object> params) {
        List<SysLogLoginEntity> entityList = getObjectList(params);
        return ConvertUtils.sourceToTarget(entityList, SysLogLoginDto.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysLogLoginDto dto) {
    	SysLogLoginEntity entity = ConvertUtils.sourceToTarget(dto, SysLogLoginEntity.class);
        insert(entity);
    }

}