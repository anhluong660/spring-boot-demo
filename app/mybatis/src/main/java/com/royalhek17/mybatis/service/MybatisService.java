package com.royalhek17.mybatis.service;

import com.royalhek17.mybatis.entities.User;
import com.royalhek17.mybatis.model.UserDO;
import com.royalhek17.mybatis.repository.UserMapper;

import org.springframework.beans.BeanUtils;
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

        User user = new User();
        BeanUtils.copyProperties(userDO, user);

        return user;
    }

    public User findUserByName(String username) {
        UserDO userDO = userMapper.findByUsername(username);
        if (userDO == null) {
            return null;
        }

        User user = new User();
        BeanUtils.copyProperties(userDO, user);

        return user;
    }

    public void insert(User user) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(user, userDO);
        userMapper.insert(userDO);
    }

    public void delete(int id) {
        userMapper.deleteById(id);
    }
}
