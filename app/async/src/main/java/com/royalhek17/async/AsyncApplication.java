package com.royalhek17.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class AsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncApplication.class, args);

        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("[[ Start Spring Async Success ]]");
        System.out.println("++++++++++++++++++++++++++++++++");
    }
}
