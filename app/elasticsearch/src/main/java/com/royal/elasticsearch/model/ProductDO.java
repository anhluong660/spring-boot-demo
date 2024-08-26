package com.royal.elasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "products")
public class ProductDO {

    @Id
    private Integer id;
    private String name;
    private Double price;
}
