/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/24 16:42
 **/
package com.wip.service.meta;

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

}
