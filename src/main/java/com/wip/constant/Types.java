package com.wip.constant;

/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/23 10:57
 **/
public enum Types {

    CATEGORY("category"),
    CSRF_TOKEN("csrf_token");

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

