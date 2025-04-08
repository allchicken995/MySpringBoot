package com.godlikexyj.modules.log.service.impl;

import com.godlikexyj.common.page.PageData;
import com.godlikexyj.common.service.impl.BaseServiceImpl;
import com.godlikexyj.common.utils.ConvertUtils;
import com.godlikexyj.modules.log.dao.SysLogErrorDao;
import com.godlikexyj.modules.log.dto.SysLogErrorDto;
import com.godlikexyj.modules.log.entity.SysLogErrorEntity;
import com.godlikexyj.modules.log.service.SysLogErrorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 异常日志
 *
 * @author xyj godlikexyj@gmail.com
 * @since 1.0.0
 */
@Service
public class SysLogErrorServiceImpl extends BaseServiceImpl<SysLogErrorDao, SysLogErrorEntity> implements SysLogErrorService {

    @Override
    public PageData<SysLogErrorDto> page(Map<String, Object> params) {
		return getPage(params,SysLogErrorDto.class);
    }

    @Override
    public List<SysLogErrorDto> list(Map<String, Object> params) {
        List<SysLogErrorEntity> entityList = getObjectList(params);
        return ConvertUtils.sourceToTarget(entityList, SysLogErrorDto.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysLogErrorEntity entity) {
        insert(entity);
    }

}