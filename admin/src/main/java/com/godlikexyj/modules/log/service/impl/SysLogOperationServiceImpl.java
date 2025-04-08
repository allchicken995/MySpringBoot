package com.godlikexyj.modules.log.service.impl;

import com.godlikexyj.common.page.PageData;
import com.godlikexyj.common.service.impl.BaseServiceImpl;
import com.godlikexyj.common.utils.ConvertUtils;
import com.godlikexyj.modules.log.dao.SysLogOperationDao;
import com.godlikexyj.modules.log.dto.SysLogOperationDto;
import com.godlikexyj.modules.log.entity.SysLogOperationEntity;
import com.godlikexyj.modules.log.service.SysLogOperationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 操作日志
 *
 * @author xyj godlikexyj@gmail.com
 * @since 1.0.0
 */
@Service
public class SysLogOperationServiceImpl extends BaseServiceImpl<SysLogOperationDao, SysLogOperationEntity> implements SysLogOperationService {

    @Override
    public PageData<SysLogOperationDto> page(Map<String, Object> params) {
        return getPage(params,SysLogOperationDto.class);
    }

    @Override
    public List<SysLogOperationDto> list(Map<String, Object> params) {
        List<SysLogOperationEntity> entityList = getObjectList(params);
        return ConvertUtils.sourceToTarget(entityList, SysLogOperationDto.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysLogOperationEntity entity) {
        insert(entity);
    }

}