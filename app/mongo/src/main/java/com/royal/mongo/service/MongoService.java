package com.royal.mongo.service;

import com.royal.mongo.entities.User;
import com.royal.mongo.model.UserDO;
import com.royal.mongo.repository.UserRepository;

import com.royal.utils.SampleUtils;
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
