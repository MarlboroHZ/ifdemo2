package com.ifdemo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * className: CacheCollection
 * description:
 *
 * @author: wjh
 * @date: 2020/11/09 18:12
 * @copyright (c) 2020, all rights reserved
 **/
public class CacheCollection {

    private static Map<String, Class> ALL_DATA_SOURCE;

    static {
        ALL_DATA_SOURCE = new HashMap<>(100);
    }

    /**
     * 根据策略名获取 Class
     * @param dsType
     * @return
     */
    public static Class getDS(String dsType) {
        return ALL_DATA_SOURCE.get(dsType);
    }
    /**
     * 策略名为 key,Class 为 value
     */
    public static void putClass(String dsType,Class clazz){
        ALL_DATA_SOURCE.put(dsType,clazz);
    }
}

