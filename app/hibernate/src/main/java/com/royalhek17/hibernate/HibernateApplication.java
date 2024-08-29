package com.royalhek17.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication {

    private static final Logger log = LoggerFactory.getLogger(HibernateApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);

        log.info("++++++++++++++++++++++++++++++++++++");
        log.info("[[ Start Spring Hibernate Success ]]");
        log.info("++++++++++++++++++++++++++++++++++++");
    }
}
