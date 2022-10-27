package com.elec5619.recipeweb.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.elec5619.recipeweb.bean.Contact;
import com.elec5619.recipeweb.bean.User;

import java.io.IOException;
import java.util.List;

/** User module Service Interface*/
public interface IUserService extends IService<User> {


    /**
     * @author Andy
     * @param user user entity
     * @return
     */
    User reg(User user);


    /**
     * @author Andy
     * @param username username
     * @param password password
     * @return matching User info
     * user login
     * */
    User login(String username, String password);

    String press(String url) throws IOException;

    String convert(String url) throws InterruptedException;

    void saveImage(String url, int uid);

    List<User> getFriendList(List<Contact> contacts);
}
