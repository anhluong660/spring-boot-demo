package com.royalhek17.mybatis.service;

import com.royalhek17.mybatis.entities.User;
import com.royalhek17.mybatis.model.UserDO;
import com.royalhek17.mybatis.repository.UserMapper;

import com.royalhek17.utils.SampleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MybatisService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id) {
        UserDO userDO = userMapper.findUserById(id);
        if (userDO == null) {
            return null;
        }

        return SampleUtils.copyProperties(userDO, User.class);
    }

    public User findUserByName(String username) {
        UserDO userDO = userMapper.findByUsername(username);
        if (userDO == null) {
            return null;
        }

        return SampleUtils.copyProperties(userDO, User.class);
    }

    public void insert(User user) {
        UserDO userDO = SampleUtils.copyProperties(user, UserDO.class);
        userMapper.insert(userDO);
    }

    public void delete(int id) {
        userMapper.deleteById(id);
    }
}
