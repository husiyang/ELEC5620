-- mysql

drop table if exists user_chatroom;

create table user_chatroom (
                            `id` Int AUTO_INCREMENT,
                            `memberid` Int,
                            `chatroomid` Int,

                            primary key (id)
) CHARSET = utf8;
