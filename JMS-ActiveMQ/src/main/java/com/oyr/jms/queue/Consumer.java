package com.oyr.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * Create by 欧阳荣
 * 2018/4/7 10:54
 */
public class Consumer {

    private static String url = "tcp://192.168.100.21:61616";

    private static String name = "queue-test";

    public static void main(String[] args) throws JMSException, IOException {
        //创建ConnectionFactory
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //创建connection
        Connection connection = factory.createConnection();
        //开启连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建一个目标
        Destination destination = session.createQueue(name);
        //创建消费者
        MessageConsumer consumer = session.createConsumer(destination);
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("消费消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //关闭连接
//        connection.close();
    }

}
