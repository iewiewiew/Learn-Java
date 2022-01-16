package org.example.controller;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import org.example.utils.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author weimenghua
 * @time 2023-01-06 10:30
 * @description
 */
public class Producer {
    // 声明队列的名字
    private static final String QUEUE_NAME = "rabbitmq_test_1";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1. 获取连接
        Connection connection = ConnectionUtils.getConnection();
        // 2. 创建数据传输通道
        Channel channel = connection.createChannel();
        // 3. 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 4. 发送数据到队列
        channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, "rabbitmq_test_1, 第一个队列消息...".getBytes());
        // 5. 关闭通道
        channel.close();
        // 6. 关闭连接
        connection.close();
    }
}
