package com.example.springcloud.controller;

import com.example.springcloud.entity.CommonResult;
import com.example.springcloud.entity.User;
import com.example.springcloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user/create")
    public CommonResult<User> create(@RequestBody User user){
        int result = userService.create(user);
        log.info("*****插入结果："+result);
        if (result>0){  //成功
            return new CommonResult(200,"插入数据库成功",result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/user/get/{id}")
    public CommonResult<User> getPaymentById(@PathVariable("id") Long id){
        User result = userService.getUserById(id);
        log.info("*****查询结果："+result);
        if (result!=null){  //说明有数据，能查询成功
            return new CommonResult(200,"查询成功",result);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID："+id,null);
        }
    }
}
