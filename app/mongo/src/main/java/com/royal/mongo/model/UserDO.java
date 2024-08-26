package com.royal.mongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("user")
public class UserDO {
    private Integer id;
    private String username;
    private Long money;
}
