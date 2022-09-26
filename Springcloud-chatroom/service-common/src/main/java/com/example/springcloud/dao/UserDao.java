package com.example.springcloud.dao;

import com.example.springcloud.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserDao {

    public int create(User user);
    public User getUserById(@Param("id") long uid);
}
