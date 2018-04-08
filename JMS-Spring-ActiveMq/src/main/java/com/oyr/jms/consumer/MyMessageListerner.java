package com.oyr.jms.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Create by 欧阳荣
 * 2018/4/7 19:46
 */
public class MyMessageListerner implements MessageListener {

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("消费消息：" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
