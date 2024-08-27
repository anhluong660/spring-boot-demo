package com.royalhek17.mongo.service;

import com.royalhek17.mongo.entities.User;
import com.royalhek17.mongo.model.UserDO;
import com.royalhek17.mongo.repository.UserRepository;

import com.royalhek17.utils.SampleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

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
        return SampleUtils.copyProperties(userDO, User.class);
    }

    public void addNewUser(User user) {
        UserDO userDO = SampleUtils.copyProperties(user, UserDO.class);
        if (userDO != null) {
            userRepository.save(userDO);
        }
    }
}
