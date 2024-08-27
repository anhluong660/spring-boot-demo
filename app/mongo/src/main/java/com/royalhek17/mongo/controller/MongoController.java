package com.royalhek17.mongo.controller;

import com.royalhek17.utils.Response;
import com.royalhek17.mongo.entities.User;
import com.royalhek17.mongo.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    private MongoService mongoService;

    @GetMapping("/user/{id}")
    public Response<User> findUserById(@PathVariable Integer id) {
        User user = mongoService.findUserById(id);
        if (user != null) {
            return Response.success(user);
        } else {
            return Response.error("Not found");
        }
    }

    @PostMapping("/add-user")
    public Response<User> addNewUser(@RequestBody User user) {
        mongoService.addNewUser(user);
        return Response.success(user);
    }
}
