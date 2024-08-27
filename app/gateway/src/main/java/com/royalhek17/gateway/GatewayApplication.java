package com.royalhek17.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);

        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("[[ Start Spring Boot Success ]]");
        System.out.println("+++++++++++++++++++++++++++++++");
    }
}
