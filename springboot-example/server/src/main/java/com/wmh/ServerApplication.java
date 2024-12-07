package com.wmh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import lombok.extern.slf4j.Slf4j;
import java.net.InetAddress;

/**
 * @author weimenghua
 * @time 2024-12-07 12:15
 * @description
 */

@Slf4j
@SpringBootApplication
@MapperScan("com.wmh.example.mapper")
public class ServerApplication {
    public static void main(String[] args) throws Exception{
        // 启动 Spring Boot 应用的核心，它初始化了 Spring 应用上下文，设置了环境，并让应用程序准备好接受请求。
        ConfigurableApplicationContext application = SpringApplication.run(ServerApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");

        log.info("\n---------------------------------------------------------------------------------------------------\n\t" +
                "Application is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + "/example/list" + "\n\t" +
                "External: \thttp://" + ip + ":" + port + "/example/list" + "\n\t" +
                "接口文档: \thttp://" + ip + ":" + port + "/doc.html\n" +
                "----------------------------------------------------------------------------------------------------");
    }
}