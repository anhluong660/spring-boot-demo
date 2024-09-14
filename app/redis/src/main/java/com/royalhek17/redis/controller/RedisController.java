package com.royalhek17.redis.controller;

import com.royalhek17.redis.entities.Item;
import com.royalhek17.utils.Response;
import com.royalhek17.redis.dto.Storage;
import com.royalhek17.redis.service.RedisService;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RMapCache;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/send-text")
    public Response<String> sendTextMessage(@RequestParam String message) {
        redisService.sendTextMessage(message);
        return Response.success("Send text ok", message);
    }

    @GetMapping("/storage/{userId}")
    public Response<Storage> getStorageByUserId(@PathVariable Integer userId) {
        Storage storage = redisService.getStorageByUserId(userId);
        if (storage != null) {
            redisService.sendObjectMessage(storage);
            return Response.success(storage);
        } else {
            return Response.error("not found");
        }
    }

    @PostMapping("/add-storage")
    public Response<Storage> addNewStorage(@RequestBody Storage storage) {
        redisService.addNewStorage(storage);
        return Response.success(storage);
    }

    @GetMapping("/redisson-atomic")
    public Long testAtomic() {
        RAtomicLong atomicLong = redissonClient.getAtomicLong("Id");
        return atomicLong.getAndIncrement();
    }

    @GetMapping("/redisson-map")
    public Map<Integer, String> testMap() {
        RMap<Integer, String> map = redissonClient.getMap("Map");
        map.put(1, "java");
        map.put(2, "C#");
        map.put(3, "Javascript");
        return map;
    }

    @GetMapping("/redisson-lock")
    public String testLock() throws InterruptedException {
        RLock lock = redissonClient.getLock("Lock");

        String status = "Task ";

        if (lock.tryLock(15, 10, TimeUnit.SECONDS)) {
            status += "Finish";
            lock.unlock();
        } else {
            status += "Fail";
        }

        return status;
    }

    @GetMapping("/redisson-cache")
    public Map<String, String> testCache() {
        RMapCache<String, String> map = redissonClient.getMapCache("Cache");
        map.put("Banana", "Fruit", 30, TimeUnit.SECONDS);
        map.put("Dog", "Animal", 1, TimeUnit.HOURS);
        map.put("Chair", "Thing", 2, TimeUnit.DAYS);
        return map;
    }

    @GetMapping("/redisson-publish")
    public String testPubSub() {
        RTopic topic = redissonClient.getTopic("Topic");

        Item item = new Item();
        item.setName("Gold");
        item.setNum(12450000);

        topic.publish(item);
        return "Ok";
    }

    @GetMapping("/redisson-subscribe")
    private void listen() {
        RTopic topic = redissonClient.getTopic("Topic");
        topic.addListener(Item.class, ((channel, msg) -> {
            System.out.println("received message: " + msg);
        }));
    }


}
