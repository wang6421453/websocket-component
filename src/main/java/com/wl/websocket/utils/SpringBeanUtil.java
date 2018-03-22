package com.wl.websocket.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wl on 2018/3/17.
 */

@Component
public class SpringBeanUtil implements ApplicationContextAware {

    private Map<String, Object> beans;

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        //获得所有serviceBeans
        beans =ac.getBeansWithAnnotation(org.springframework.stereotype.Component.class);
    }

    /**
     * 从spring容器中获得指定接口实现实例
     * 从spring容器中获得实现@service 所有bean中实现 interfaceType接口的实例
     *
     * @param interfaceType 需要和 I.class一样
     * @return
     */
    public List<Object> getBeansByInterface(Class<?> interfaceType){
        List<Object> tList = new ArrayList<Object>();
        for(String key : beans.keySet()) {
            Object obj = beans.get(key);
            for(Class<?> c : obj.getClass().getInterfaces()) {
                if(c.getName().equals(interfaceType.getName())) {
                    tList.add(obj);
                }
            }
        }
        return tList;
    }
}
