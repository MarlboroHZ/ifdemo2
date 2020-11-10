package com.ifdemo.init;

import com.ifdemo.base.DataSourceStrategy;
import com.ifdemo.util.CacheCollection;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * className: DataSourceContextAware
 * description:
 *
 * @author: wjh
 * @date: 2020/11/09 18:14
 * @copyright (c) 2020, all rights reserved
 **/
@Component
public class DataSourceContextAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public DataSourceStrategy getStrategyInstance(String dsType) {
        Class clazz = CacheCollection.getDS(dsType);
        DataSourceStrategy dataSourceStrategy = (DataSourceStrategy) applicationContext.getBean(clazz);
        return dataSourceStrategy;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

