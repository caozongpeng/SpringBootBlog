/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/24 17:03
 **/
package com.wip.dao;

import com.wip.dto.cond.MetaCond;
import com.wip.model.MetaDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MetaDao {

    /**
     * 添加项目
     * @param meta  项目对象
     * @return
     */
    int addMeta(MetaDomain meta);

    /**
     * 更新项目
     * @param meta  项目对象
     * @return
     */
    int updateMeta(MetaDomain meta);

    /**
     * 根据条件查询
     * @param metaCond
     * @return
     */
    List<MetaDomain> getMetasByCond(MetaCond metaCond);

    /**
     * 根据ID获取项目
     * @param mid
     * @return
     */
    MetaDomain getMetaById(@Param("mid") Integer mid);

}
