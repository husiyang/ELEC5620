-- mysql

drop table if exists t_user;

create table t_user (
                        `uid` Int AUTO_INCREMENT comment '用户id',
                        `username` Varchar(20) NOT NULL UNIQUE comment '用户名',
                        `password` Char(32) NOT NULL comment '密码',
                        `studentid` Char(32) comment '学生id',
                        `birth` Varchar(20) comment '生日',
                        `age` Varchar(20) comment '年龄',
                        `avatar` Varchar(50) comment '头像',
                        `role` Int comment '用户身份 0-学生 1-访客 2-管理员',

                        primary key (uid)
) CHARSET = utf8;
