package com.royal.redis.controller;

import com.royal.utils.Response;
import com.royal.redis.dto.Storage;
import com.royal.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

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
}
