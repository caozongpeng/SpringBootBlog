/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/24 16:43
 **/
package com.wip.service.meta.impl;

import com.wip.constant.ErrorConstant;
import com.wip.dto.cond.MetaCond;
import com.wip.exception.BusinessException;
import com.wip.service.meta.MetaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 项目相关Service接口实现
 */
@Service
public class MetaServiceImpl implements MetaService {

    @Override
    public void saveMeta(String type, String name, Integer mid) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(name)) {
            MetaCond metaCond = new MetaCond();
            metaCond.setName(name);
            metaCond.setType(type);


        } else {
            throw BusinessException.withErrorCode(ErrorConstant.Meta.META_IS_EXIST);
        }
    }
}
