package com.royal.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchApplication.class, args);

		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		System.out.println("[[ Start Spring Elasticsearch Success ]]");
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
	}

}
