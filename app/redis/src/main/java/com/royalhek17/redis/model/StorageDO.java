package com.royalhek17.redis.model;

import com.royalhek17.redis.entities.Item;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash("Storage")
@Data
public class StorageDO {
    @Id
    private Integer userId;

    private List<Item> items;
}
