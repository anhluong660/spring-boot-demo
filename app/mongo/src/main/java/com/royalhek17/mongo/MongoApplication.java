package com.royalhek17.mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoApplication {

    private static final Logger log = LoggerFactory.getLogger(MongoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);

        log.info("++++++++++++++++++++++++++++++++++");
        log.info("[[ Start Spring MongoDB Success ]]");
        log.info("++++++++++++++++++++++++++++++++++");
    }
}
