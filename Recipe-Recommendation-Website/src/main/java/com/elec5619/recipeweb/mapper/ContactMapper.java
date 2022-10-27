package com.elec5619.recipeweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elec5619.recipeweb.bean.Contact;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContactMapper extends BaseMapper<Contact> {

    List<Contact> findByStudentId(String studentid);

    Contact findByStudentIdAndFriendId(String studentid, String friendid);
}
