/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/23 16:59
 **/
package com.wip.service.log.impl;

import com.wip.dao.LogDao;
import com.wip.model.LogDomain;
import com.wip.service.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 日志相关Service接口实现
 */
@Service
public class LogServiceImpl implements LogService {


    @Autowired
    private LogDao logDao;


    @Override
    public void addLog(String action, String data, String ip, Integer authorId) {
        LogDomain logDomain = new LogDomain();
        logDomain.setAuthorId(authorId);
        logDomain.setIp(ip);
        logDomain.setData(data);
        logDomain.setAction(action);
        logDao.addLog(logDomain);
    }
}
