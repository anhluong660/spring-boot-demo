package com.royalhek17.elasticsearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticsearchApplication {

	private static final Logger log = LoggerFactory.getLogger(ElasticsearchApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchApplication.class, args);

		log.info("++++++++++++++++++++++++++++++++++++++++");
		log.info("[[ Start Spring Elasticsearch Success ]]");
		log.info("++++++++++++++++++++++++++++++++++++++++");
	}

}
