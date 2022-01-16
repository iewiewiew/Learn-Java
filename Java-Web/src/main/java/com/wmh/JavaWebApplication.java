package com.wmh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import java.net.InetAddress;

@Slf4j
@EnableAsync
@SpringBootApplication
@MapperScan("com.wmh.dao")
public class JavaWebApplication {
    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext application = SpringApplication.run(JavaWebApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");

        log.info("\n---------------------------------------------------------------------------------------------------\n\t" +
                "Application is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + "/demo/list" + "\n\t" +
                "External: \thttp://" + ip + ":" + port + "/demo/list" + "\n\t" +
                "接口文档: \thttp://" + ip + ":" + port + "/doc.html\n" +
                "----------------------------------------------------------------------------------------------------");
    }
}