package com.web.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: panyusheng
 * @Date: 2021/10/18
 * @Version 1.0
 */
public class Test {

    @org.junit.Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object bean = ac.getBean("fireDao");
        System.out.println(bean);
    }

}