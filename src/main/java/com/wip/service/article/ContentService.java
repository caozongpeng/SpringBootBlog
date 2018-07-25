/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/25 16:48
 **/
package com.wip.service.article;

import com.wip.model.ContentDomain;

/**
 * 文章相关Service接口
 */
public interface ContentService {

    /***
     * 添加文章
     * @param contentDomain
     */
    void addArticle(ContentDomain contentDomain);
}
