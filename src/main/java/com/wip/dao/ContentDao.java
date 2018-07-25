/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/25 16:50
 **/
package com.wip.dao;

import com.wip.model.ContentDomain;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章相关Dao接口
 */
@Mapper
public interface ContentDao {

    /**
     * 添加文章
     * @param contentDomain
     */
    void addArticle(ContentDomain contentDomain);
}
