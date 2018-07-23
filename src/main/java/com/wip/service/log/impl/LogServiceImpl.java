/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/23 16:59
 **/
package com.wip.service.log.impl;

import com.wip.service.log.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Override
    public void addLog(String action, String data, String ip, Integer authorId) {

    }
}
