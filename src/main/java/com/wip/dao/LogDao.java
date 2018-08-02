/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/23 17:07
 **/
package com.wip.dao;


import com.wip.model.LogDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 日志dao层接口
 */
@Mapper
public interface LogDao {

    /**
     * 添加日志
     * @param logDomain
     * @return
     */
    int addLog(LogDomain logDomain);

    /**
     * 获取日志
     * @return
     */
    List<LogDomain> getLogs();
}
