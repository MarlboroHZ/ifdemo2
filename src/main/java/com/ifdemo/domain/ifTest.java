package com.ifdemo.domain;

import com.ifdemo.init.DataSourceContextAware;
import com.ifdemo.service.DataSourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * className: ifTest
 * description:
 *
 * @author: wjh
 * @date: 2020/11/09 18:15
 * @copyright (c) 2020, all rights reserved
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ifTest {

    @Autowired
    private DataSourceService dataSourceService;
    //优化后
    @Test
    public void testOperation(){
        Map<String, Object> resp = dataSourceService.connect("faceRecognition", null);
        System.out.println(resp);
    }
}
