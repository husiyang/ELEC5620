package com.elec5619.recipeweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elec5619.recipeweb.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User findByUsername(String username);

    User findStudentIdByUid(int uid);

    User findByStudentid(String studentid);

}
