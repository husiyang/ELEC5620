-- mysql

drop table if exists t_chatroom;

create table t_chatroom (
                              `id` Int AUTO_INCREMENT comment 'id',
                              `size` Int comment '聊天室人数',
                              `ownerid` Int comment '聊天室主人id',

                              primary key (id)
) CHARSET = utf8;
