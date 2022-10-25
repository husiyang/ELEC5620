package com.elec5619.recipeweb.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.elec5619.recipeweb.bean.User;

/** User module Service Interface*/
public interface IUserService extends IService<User> {


    /**
     * @author Andy
     * @param user user entity
     * @return
     */
    boolean reg(User user);


    /**
     * @author Andy
     * @param username username
     * @param password password
     * @return matching User info
     * user login
     * */
    User login(String username, String password);
}
