package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author weimenghua
 * @time ${YEAR}-${MONTH}-${DAY} ${TIME}
 * @description
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(Application.class, args);
    }
}