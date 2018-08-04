package com.wip.constant;

/**
 * 日志表的action字段
 */
public enum LogActions {

    LOGIN("登录后台"),
    UP_PWD("修改密码"),
    UP_INFO("修改个人信息"),
    DEL_ARTICLE("删除文章"),
    SYS_SETTING("保存系统设置"),
    DEL_ATTACH("删除附件");

    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    LogActions(String action) {
        this.action = action;
    }

}
