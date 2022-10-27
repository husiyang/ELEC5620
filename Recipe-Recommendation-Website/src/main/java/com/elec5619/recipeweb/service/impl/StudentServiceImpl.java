package com.elec5619.recipeweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elec5619.recipeweb.bean.Contact;
import com.elec5619.recipeweb.bean.User;
import com.elec5619.recipeweb.mapper.ContactMapper;
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
}
