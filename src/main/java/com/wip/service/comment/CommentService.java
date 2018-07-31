/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/31 15:40
 **/
package com.wip.service.comment;

import com.wip.model.CommentDomain;

public interface CommentService {

    /**
     * 添加评论
     * @param comments
     */
    void addComment(CommentDomain comments);
}
