package com.royalhek17.mongo.controller;

import com.royalhek17.mongo.entities.Account;
import com.royalhek17.mongo.utils.JwtUtil;
import com.royalhek17.utils.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Response<String> login(@Valid @RequestBody Account account) {
        if (account.getUsername().equals("royalhek17") && account.getPassword().equals("123456")) {
            String token = jwtUtil.generateToken(account.getUsername());
            return Response.success(token);
        }

        return Response.error("login fail");
    }
}
