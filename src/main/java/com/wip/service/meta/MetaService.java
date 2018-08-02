/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/24 16:42
 **/
package com.wip.service.meta;

import com.wip.dto.MetaDto;
import com.wip.dto.cond.MetaCond;
import com.wip.model.MetaDomain;

import java.util.List;

/**
 * 项目相关Service接口
 */
public interface MetaService {

    /**
     * 添加
     * @param type      项目类型
     * @param name      项目名称
     * @param mid       项目ID
     */
    void saveMeta(String type, String name, Integer mid);

    /**
     * 根据类型查询项目列表，带项目正面的文章数
     * @param type      项目类型
     * @param orderBy   排序字段
     * @param limit     限制条数
     * @return
     */
    List<MetaDto> getMetaList(String type, String orderBy, int limit);

    /**
     * 添加或者更新
     * @param cid
     * @param name
     * @param type
     */
    void saveOrUpdate(Integer cid, String name, String type);

    /**
     * 批量添加
     * @param cid
     * @param names
     * @param type
     */
    void addMetas(Integer cid, String names, String type);

    /**
     * 删除项目
     * @param mid
     */
    void deleteMetaById(Integer mid);

    /**
     * 获取所有项目
     * @param metaCond  查询条件
     * @return
     */
    List<MetaDomain> getMetas(MetaCond metaCond);

    /**
     * 添加项目
     * @param meta
     */
    void addMea(MetaDomain meta);

    /**
     * 更新项目
     * @param meta
     */
    void updateMeta(MetaDomain meta);

    /**
     * 通过类型获取项目总数
     * @param type
     * @return
     */
    Long getMetasCountByType(String type);

    /**
     * 通过Meta名查找Meta项目
     * @param type
     * @param name
     * @return
     */
    MetaDomain getMetaByName(String type, String name);
}
