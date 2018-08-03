/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/8/2 8:48
 **/
package com.wip.service.site;

import com.wip.dto.StatisticsDto;
import com.wip.model.CommentDomain;
import com.wip.model.ContentDomain;

import java.util.List;

/**
 * 网站相关Service接口
 */
public interface SiteService {

    /**
     * 获取评论列表
     * @param limit
     * @return
     */
    List<CommentDomain> getComments(int limit);

    /**
     * 获取文章列表
     * @param limit
     * @return
     */
    List<ContentDomain> getNewArticles(int limit);

    /**
     * 获取后台统计数
     * @return
     */
    StatisticsDto getStatistics();
}
