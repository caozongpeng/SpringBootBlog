/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/23 16:57
 **/
package com.wip.service.log;


import com.github.pagehelper.PageInfo;
import com.wip.model.LogDomain;

/**
 * 日志相关Service接口
 */
public interface LogService {

    /**
     * 添加日志
     * @param action    触发动作
     * @param data      产生数据
     * @param ip        产生IP
     * @param authorId  产生人
     */
    void addLog(String action, String data, String ip, Integer authorId);

    /**
     * 获取日志
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<LogDomain> getLogs(int pageNum, int pageSize);
}
