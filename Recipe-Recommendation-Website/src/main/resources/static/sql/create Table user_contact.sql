-- mysql

drop table if exists user_contact;

create table user_contact (
                        `id` Int AUTO_INCREMENT comment 'id',
                        `studentid` Char(32) comment '学生id',
                        `friendid` Char(32) comment '好友id',

                        primary key (id)
) CHARSET = utf8;
