package com.royal.rabbitmq.entities;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private Integer id;
    private String username;
    private Long money;
}
