package com.royalhek17.redis.service;

import com.royalhek17.redis.config.RedisConfig;
import com.royalhek17.redis.dto.Storage;
import com.royalhek17.redis.model.StorageDO;
import com.royalhek17.redis.repository.StorageRepository;
import com.royalhek17.utils.SampleUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisService implements MessageListener {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StorageRepository storageRepository;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        Object obj = serializer.deserialize(message.getBody());

        if (obj instanceof String string) {
            log.info("Redis listener: {}", string);
        }
        else if (obj instanceof Storage storage) {
            log.info("Redis listener: {}", storage);
        }
        else {
            log.error("Not found parser for message");
        }
    }

    public void sendTextMessage(String message) {
        redisTemplate.convertAndSend(RedisConfig.TOPIC_CHANNEL, message);
    }

    public void sendObjectMessage(Storage storage) {
        redisTemplate.convertAndSend(RedisConfig.TOPIC_CHANNEL, storage);
    }

    public Storage getStorageByUserId(int userId) {
        StorageDO storageDO = storageRepository.findById(userId).orElse(null);
        if (storageDO == null) {
            return null;
        }

        return SampleUtils.copyProperties(storageDO, Storage.class);
    }

    public void addNewStorage(Storage storage) {
        StorageDO storageDO = SampleUtils.copyProperties(storage, StorageDO.class);
        storageRepository.save(storageDO);
    }
}
