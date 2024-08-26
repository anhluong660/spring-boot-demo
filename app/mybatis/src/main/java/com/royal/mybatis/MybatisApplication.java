package com.royal.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);

        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("[[ Start Spring Mybatis Success ]]");
        System.out.println("++++++++++++++++++++++++++++++++++");
    }
}
