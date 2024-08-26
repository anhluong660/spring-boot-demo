package com.royal.mybatis.service;

import com.royal.mybatis.entities.User;
import com.royal.mybatis.model.UserDO;
import com.royal.mybatis.repository.UserMapper;

import com.royal.utils.SampleUtils;
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
        if (userDO != null) {
            userMapper.insert(userDO);
        }
    }

    public void delete(int id) {
        userMapper.deleteById(id);
    }
}
