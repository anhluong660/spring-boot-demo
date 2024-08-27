package com.royalhek17.mybatis.controller;

import com.royalhek17.utils.Response;
import com.royalhek17.mybatis.entities.User;
import com.royalhek17.mybatis.service.MybatisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private MybatisService mybatisService;

    @GetMapping("/user/{id}")
    public Response<User> findUser(@PathVariable Integer id) {
        User user = mybatisService.findUserById(id);
        if (user != null) {
            return Response.success(user);
        } else {
            return Response.error("Not found");
        }
    }

    @GetMapping("/username/{name}")
    public Response<User> findUser(@PathVariable String name) {
        User user = mybatisService.findUserByName(name);
        if (user != null) {
            return Response.success(user);
        } else {
            return Response.error("Not found");
        }
    }

    @PostMapping("/add-user")
    public Response<User> addNewUser(@RequestBody User user) {
        mybatisService.insert(user);
        return Response.success(user);
    }

    @DeleteMapping("/delete-user/{id}")
    public Response<User> deleteUser(@PathVariable Integer id) {
        mybatisService.delete(id);
        return Response.success(String.format("Delete user id %s success !", id));
    }
}
