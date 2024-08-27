package com.royalhek17.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);

        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("[[ Start Spring Redis Success ]]");
        System.out.println("++++++++++++++++++++++++++++++++");
    }
}
