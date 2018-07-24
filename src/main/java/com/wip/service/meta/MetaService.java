/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/24 16:42
 **/
package com.wip.service.meta;

import com.wip.dto.MetaDto;

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

}
