package com.elec5619.recipeweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elec5619.recipeweb.bean.UserChatroom;

import java.util.List;

public interface UserChatroomMapper extends BaseMapper<UserChatroom> {

    List<UserChatroom> findByMemberid(int memberid);
}
