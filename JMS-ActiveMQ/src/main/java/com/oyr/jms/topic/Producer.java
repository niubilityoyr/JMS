package com.oyr.jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Create by 欧阳荣
 * 2018/4/7 10:40
 */
public class Producer {

    private static String url = "tcp://192.168.100.21:61616";

    private static String name = "topic-test";

    public static void main(String[] args) throws JMSException {
        //创建ConnectionFactory
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //创建connection
        Connection connection = factory.createConnection();
        //开启连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建一个目标
        Destination destination = session.createTopic(name);
        //创建生产者
        MessageProducer producer = session.createProducer(destination);

        for (int i=0; i<100; i++){
            //创建消息
            TextMessage textMessage = session.createTextMessage("message" + i);
            //发送消息
            producer.send(textMessage);
        }

        //关闭连接
        connection.close();
    }

}
