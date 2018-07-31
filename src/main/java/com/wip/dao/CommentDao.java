/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/31 15:42
 **/
package com.wip.dao;

import com.wip.model.CommentDomain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentDao {

    /**
     * 添加评论
     * @param comments
     */
    void addComment(CommentDomain comments);
}
