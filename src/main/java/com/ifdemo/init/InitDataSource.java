package com.ifdemo.init;

import com.ifdemo.annotation.DataSourceType;
import com.ifdemo.util.CacheCollection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.URL;

/**
 * className: InitDataSource
 * description:
 *
 * @author: wjh
 * @date: 2020/11/09 18:12
 * @copyright (c) 2020, all rights reserved
 **/
@Component
public class InitDataSource {

    @Value("${haoxy.package}")
    private String packageVo;

    @PostConstruct
    public void init() {
        initAllDataSourceType(packageVo);
    }

    private void initAllDataSourceType(String packageVo) {
        URL url = this.getClass().getClassLoader().getResource(packageVo.replace(".", "/"));
        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                continue;
            } else {
                String className = packageVo + "." + file.getName().replace(".class", "");
                try {
                    Class<?> clazz = Class.forName(className);// class cn.haoxy.ref.inter.impl.faceRecognition
                    //判断这个类上是否存在指定的注解
                    if (clazz.isAnnotationPresent(DataSourceType.class)) {
                        //如果存在,得到此注解的value值
                        DataSourceType dataSourceType = clazz.getAnnotation(DataSourceType.class);
                        //放入容器
                        CacheCollection.putClass(dataSourceType.value(), clazz);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }
    }
}


