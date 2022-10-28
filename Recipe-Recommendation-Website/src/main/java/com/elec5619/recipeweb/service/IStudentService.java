package com.elec5619.recipeweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elec5619.recipeweb.bean.Chatroom;
import com.elec5619.recipeweb.bean.Contact;
import com.elec5619.recipeweb.bean.UserChatroom;

import java.util.List;

public interface IStudentService extends IService<Contact> {

    Contact addfriend(String studentid, int uid);

    List<Contact> getFriendList(int uid);

    Chatroom createChatroom(String[] contact_student_id, int uid);

    List<UserChatroom> getChatroomList(int uid);
}
