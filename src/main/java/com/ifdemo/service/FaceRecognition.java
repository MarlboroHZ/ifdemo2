package com.ifdemo.service;

import com.alibaba.fastjson.JSONObject;
import com.ifdemo.annotation.DataSourceType;
import com.ifdemo.base.DataSourceStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * className: FaceRecognition
 * description:
 *
 * @author: wjh
 * @date: 2020/11/09 18:06
 * @copyright (c) 2020, all rights reserved
 **/
@Component
@DataSourceType("faceRecognition")
public class FaceRecognition implements DataSourceStrategy {


    @Override
    public Map<String, Object> connect(Map<String, String> params) {
        //do something....

        //返回结果
        JSONObject json = new JSONObject();
        json.put("type", "人脸识别");
        json.put("status", "success");
        return json;
    }
}


