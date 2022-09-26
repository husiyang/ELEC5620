package com.example.springcloud.service.impl;

import com.example.springcloud.dao.UserDao;
import com.example.springcloud.entity.User;
import com.example.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int create(User user) {
        return userDao.create(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
