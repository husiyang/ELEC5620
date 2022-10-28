package com.elec5619.recipeweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elec5619.recipeweb.bean.Chatroom;
import com.elec5619.recipeweb.bean.Contact;
import com.elec5619.recipeweb.bean.User;
import com.elec5619.recipeweb.bean.UserChatroom;
import com.elec5619.recipeweb.mapper.ChatroomMapper;
import com.elec5619.recipeweb.mapper.ContactMapper;
import com.elec5619.recipeweb.mapper.UserChatroomMapper;
import com.elec5619.recipeweb.mapper.UserMapper;
import com.elec5619.recipeweb.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<ContactMapper, Contact> implements IStudentService {

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ChatroomMapper chatroomMapper;

    @Autowired
    private UserChatroomMapper userChatroomMapper;

    @Override
    public Contact addfriend(String studentid, int uid) {
        if(studentid == null || studentid.equals("")){
            return null;
        }

        User user = userMapper.findStudentIdByUid(uid);
        String userStudentId = user.getStudentid();

        Contact contact1 = contactMapper.findByStudentIdAndFriendId(userStudentId,studentid);
        if(contact1 != null){
            return null;
        }

        Contact insertContact = new Contact();
        insertContact.setStudentid(userStudentId);
        insertContact.setFriendid(studentid);

        Integer rows = contactMapper.insert(insertContact);
        if (rows != 1) {
            return null;
        }

        return contactMapper.findByStudentIdAndFriendId(userStudentId,studentid);
    }

    @Override
    public List<Contact> getFriendList(int uid) {
        User user = userMapper.findStudentIdByUid(uid);
        String userStudentId = user.getStudentid();
        return contactMapper.findByStudentId(userStudentId);
    }

    @Override
    public Chatroom createChatroom(String[] contact_student_id, int uid) {
        int size = contact_student_id.length;
        Chatroom chatroom = new Chatroom();
        chatroom.setOwnerid(uid);
        chatroom.setSize(size+1);
        Integer rows = chatroomMapper.insert(chatroom);
        if (rows != 1) {
            return null;
        }
        Chatroom newChatroom = chatroomMapper.findByOwnerid(uid);
        int chatroomid = newChatroom.getId();
        UserChatroom userChatroom_owner = new UserChatroom();
        userChatroom_owner.setMemberid(uid);
        userChatroom_owner.setChatroomid(chatroomid);
        Integer rows_owner = userChatroomMapper.insert(userChatroom_owner);
        if (rows_owner != 1) {
            return null;
        }
        for(String studentid : contact_student_id){
            UserChatroom userChatroom_friend = new UserChatroom();
            User user = userMapper.findByStudentid(studentid);
            userChatroom_friend.setMemberid(user.getUid());
            userChatroom_friend.setChatroomid(chatroomid);
            Integer rows_friend = userChatroomMapper.insert(userChatroom_friend);
            if (rows_friend != 1) {
                return null;
            }
        }
        return chatroom;
    }

    @Override
    public List<UserChatroom> getChatroomList(int uid) {
        return userChatroomMapper.findByMemberid(uid);
    }
}
