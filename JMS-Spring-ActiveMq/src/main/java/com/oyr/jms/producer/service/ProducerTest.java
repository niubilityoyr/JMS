package com.oyr.jms.producer.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create by 欧阳荣
 * 2018/4/7 19:11
 */
public class ProducerTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service = applicationContext.getBean(ProducerService.class);
        for (int i=0;i<100;i++){
            service.send("message" + i);
        }
    }

}
