/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/24 16:43
 **/
package com.wip.service.meta.impl;

import com.wip.constant.ErrorConstant;
import com.wip.constant.WebConst;
import com.wip.dao.MetaDao;
import com.wip.dao.RelationShipDao;
import com.wip.dto.MetaDto;
import com.wip.dto.cond.MetaCond;
import com.wip.exception.BusinessException;
import com.wip.model.MetaDomain;
import com.wip.model.RelationShipDomain;
import com.wip.service.meta.MetaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目相关Service接口实现
 */
@Service
public class MetaServiceImpl implements MetaService {

    @Autowired
    private MetaDao metaDao;

    @Autowired
    private RelationShipDao relationShipDao;

    @Override
    public void saveMeta(String type, String name, Integer mid) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(name)) {
            MetaCond metaCond = new MetaCond();
            metaCond.setName(name);
            metaCond.setType(type);
            // 通过项目名和类型查找有没有存在的
            List<MetaDomain> metas = metaDao.getMetasByCond(metaCond);
            // 判断是否找到有相同的
            if (null == metas || metas.size() ==0) {
                MetaDomain metaDomain = new MetaDomain();
                metaDomain.setName(name);
                // 如果有mid代表需要更新
                if (null != mid) {
                    MetaDomain meta = metaDao.getMetaById(mid);
                    if (null != meta)
                        metaDomain.setMid(mid);
                    metaDao.updateMeta(metaDomain);
                    // 更新原有的文章分类

                } else {
                    // 添加分类
                    metaDomain.setType(type);
                    metaDao.addMeta(metaDomain);
                }

            } else {
                throw BusinessException.withErrorCode(ErrorConstant.Meta.META_IS_EXIST);
            }
        }
    }

    @Override
    @Cacheable(value = "metaCaches", key = "'metaList_'+ #p0")
    public List<MetaDto> getMetaList(String type, String orderBy, int limit) {
        if (StringUtils.isNotBlank(type)) {
            if (StringUtils.isBlank(orderBy)) {
                orderBy = "count desc, a.mid desc";
            }
            if (limit < 1 || limit > WebConst.MAX_POSTS) {
                limit = 10;
            }
            Map<String, Object> paraMap = new HashMap<>();
            paraMap.put("type", type);
            paraMap.put("order", orderBy);
            paraMap.put("limit", limit);
            return metaDao.selectFromSql(paraMap);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteMetaById(Integer mid) {
        if (null == mid)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);

        // 通过ID找到该项目
        MetaDomain meta = metaDao.getMetaById(mid);
        if (null != meta) {
            String type = meta.getType();
            String name = meta.getName();
            // 删除meta
            metaDao.deleteMetaById(mid);
            // 需要把相关的数据删除
            List<RelationShipDomain> relationShips = relationShipDao.getRelationShipByMid(mid);
            // 判断是否查找到项目编号
            if (null != relationShips && relationShips.size() > 0) {
                for (RelationShipDomain relationShip : relationShips) {

                }

                // 删除关联meta
                relationShipDao.deleteRelationShipByMid(mid);
            }
        }

    }

    @Override
    @Cacheable(value = "metaCaches", key = "'metas_' + #p0")
    public List<MetaDomain> getMetas(MetaCond metaCond) {
        return metaDao.getMetasByCond(metaCond);
    }
}
