package com.elec5619.recipeweb.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName(value = "t_chatroom")
@Data
public class Chatroom implements Serializable {

    private static final long serialVersionUID = -8655130590432259674L;

    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;

    private int size;

    private int ownerid;

}
