package com.wip.constant;

import com.wip.model.ContentDomain;

/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/23 10:57
 **/
public enum Types {

    // 分类
    CATEGORY("category"),
    // 标签
    TAG("tag"),
    // 文章
    ARTICLE("post"),
    // csrf_token
    CSRF_TOKEN("csrf_token"),
    // 友情链接
    LINK("link"),
    // 评论
    COMMENTS_FREQUENCY("comments:frequency");

    private String type;

    public java.lang.String getType() {
        return type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    Types(java.lang.String type) {
        this.type = type;
    }
    }

