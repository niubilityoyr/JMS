package com.oyr.jms.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create by 欧阳荣
 * 2018/4/7 19:52
 */
public class ConsumerTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("consumer.xml");
    }

}
