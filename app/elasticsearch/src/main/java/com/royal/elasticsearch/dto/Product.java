package com.royal.elasticsearch.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private Integer id;
    private String name;
    private Double price;
}
