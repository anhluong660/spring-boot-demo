package com.royalhek17.mybatis.repository;

import com.royalhek17.mybatis.model.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT* FROM users WHERE id = #{id}")
    UserDO findUserById(int id);

    @Insert("INSERT INTO users(id, username, money) VALUES(#{id}, #{username}, #{money})")
    void insert(UserDO userDO);

    UserDO findByUsername(String username);

    void deleteById(int id);
}
