package com.royal.redis.dto;

import com.royal.redis.entities.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Storage {
    private Integer userId;
    private List<Item> items;
}
