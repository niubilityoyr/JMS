package com.oyr.jms.producer.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Create by 欧阳荣
 * 2018/4/7 15:29
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Resource
    private JmsTemplate jmsTemplate;

    @Resource(name="topicDestination")
    private Destination destination;

    public void send(final String message) {
        //发送消息
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        };
        jmsTemplate.send(destination, messageCreator);
        System.out.println("消息发送：" + message);
    }

}
