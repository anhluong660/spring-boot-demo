package com.royalhek17.redis.dto;

import com.royalhek17.redis.entities.Item;
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
