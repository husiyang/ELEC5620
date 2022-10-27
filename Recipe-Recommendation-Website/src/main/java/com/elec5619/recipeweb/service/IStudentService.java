package com.elec5619.recipeweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elec5619.recipeweb.bean.Contact;

import java.util.List;

public interface IStudentService extends IService<Contact> {

    Contact addfriend(String studentid, int uid);

    List<Contact> getFriendList(int uid);
}
