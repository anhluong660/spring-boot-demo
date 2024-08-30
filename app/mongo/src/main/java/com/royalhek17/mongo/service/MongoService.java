package com.royalhek17.mongo.service;

import com.royalhek17.mongo.entities.User;
import com.royalhek17.mongo.model.UserDO;
import com.royalhek17.mongo.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;

    public User findUserById(int userId) {
        UserDO userDO = userRepository.findById(userId).orElse(null);
        if (userDO == null) {
            return null;
        }

        User user = new User();
        BeanUtils.copyProperties(userDO, user);

        return user;
    }

    public void addNewUser(User user) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(user, userDO);
        userRepository.save(userDO);
    }

    public void addMoreNewUser(List<User> userList) {
        for (User user : userList) {
            UserDO userDO = new UserDO();
            BeanUtils.copyProperties(user, userDO);
            userRepository.save(userDO);
        }
    }
}
