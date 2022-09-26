package com.example.springcloud.service;


import com.example.springcloud.entity.User;

public interface UserService {

    public int create(User user); //写
    public User getUserById(Long id);  //读取
}
