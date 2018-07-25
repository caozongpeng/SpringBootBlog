/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * DateTime: 2018/7/24 23:07
 **/
package com.wip.dao;

import com.wip.model.RelationShipDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 中间表
 */
@Mapper
public interface RelationShipDao {

    /**
     * 根据meta编号获取关联
     * @param mid
     * @return
     */
    List<RelationShipDomain> getRelationShipByMid(Integer mid);

    /**
     * 根据meta编号删除关联
     * @param mid
     */
    void deleteRelationShipByMid(Integer mid);
}
