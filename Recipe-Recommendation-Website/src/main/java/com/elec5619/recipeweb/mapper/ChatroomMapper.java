package com.elec5619.recipeweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elec5619.recipeweb.bean.Chatroom;

public interface ChatroomMapper extends BaseMapper<Chatroom> {

    Chatroom findByOwnerid(int ownerid);
}
