package org.example.config;

import io.minio.MinioClient;
import org.springframework.context.annotation.*;

/**
 * @author weimenghua
 * @time 2022-12-05 21:57
 * @description
 */
@Configuration
public class MinIOConfiguration {
    @Bean
    public MinioClient minioClient() {
        String endpoint = "http://127.0.0.1:9000";
        String accessKey = "YXTbKOdODkGW6XvN";
        String secretKey = "r3qHOOFMmQd1ouA64UAgZcAit1rGgZxk";

        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }
}
