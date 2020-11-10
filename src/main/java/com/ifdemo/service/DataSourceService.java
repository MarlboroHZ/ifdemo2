package com.ifdemo.service;

import com.ifdemo.base.DataSourceStrategy;
import com.ifdemo.init.DataSourceContextAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * className: DataSourceService
 * description:
 *
 * @author: wjh
 * @date: 2020/11/09 18:14
 * @copyright (c) 2020, all rights reserved
 **/
@Component
public class DataSourceService {

    @Autowired
    private DataSourceContextAware dataSourceContextAware;

    public Map<String, Object> connect(String dsType, Map<String, String> map) {
        DataSourceStrategy dataSourceChild = dataSourceContextAware.getStrategyInstance(dsType);
        return dataSourceChild.connect(map);
    }
}

