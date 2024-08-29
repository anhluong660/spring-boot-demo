package com.royalhek17.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class AsyncApplication {

    private static final Logger log = LoggerFactory.getLogger(AsyncApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AsyncApplication.class, args);

        log.info("++++++++++++++++++++++++++++++++");
        log.info("[[ Start Spring Async Success ]]");
        log.info("++++++++++++++++++++++++++++++++");
    }
}
