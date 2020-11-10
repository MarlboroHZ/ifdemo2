package com.ifdemo.service;

import com.alibaba.fastjson.JSONObject;
import com.ifdemo.annotation.DataSourceType;
import com.ifdemo.base.DataSourceStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * className: FourElements
 * description:
 *
 * @author: wjh
 * @date: 2020/11/09 18:11
 * @copyright (c) 2020, all rights reserved
 **/
@Component
@DataSourceType("fourElements")
public class FourElements implements DataSourceStrategy {
    @Override
    public Map<String, Object> connect(Map<String, String> params) {
        //do something....
        //返回结果
        JSONObject json = new JSONObject();
        json.put("type", "四要素");
        json.put("status", "success");
        return json;
    }
}

