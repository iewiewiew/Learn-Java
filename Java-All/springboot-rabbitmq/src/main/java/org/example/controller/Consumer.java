package org.example.controller;

import com.rabbitmq.client.*;
import org.example.utils.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author weimenghua
 * @time 2023-01-06 10:34
 * @description
 */
public class Consumer {
    // 声明队列的名字
    private static final String QUEUE_NAME = "rabbitmq_test_1";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1. 获取连接
        Connection connection = ConnectionUtils.getConnection();
        // 2. 创建通道
        Channel channel = connection.createChannel();
        // 3. 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 4. 声明消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接收到的消息是：" + new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        // 5. 绑定消费者
        channel.basicConsume(QUEUE_NAME, false, defaultConsumer);
    }
}
