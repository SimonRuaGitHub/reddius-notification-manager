package com.reddius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class ConsumerMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMQApplication.class, args);
    }
}
