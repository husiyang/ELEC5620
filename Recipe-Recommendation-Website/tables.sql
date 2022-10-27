DROP TABLE IF EXISTS t_user;

CREATE TABLE t_user (
    `uid` INT AUTO_INCREMENT,
    `username` VARCHAR(20) NOT NULL UNIQUE,
    `password` CHAR(32) NOT NULL,
    `studentid` CHAR(32),
    `birth` VARCHAR(20),
    `age` VARCHAR(20),
    `avatar` VARCHAR(150),
    `role` INT,
    PRIMARY KEY (uid)
) CHARSET = UTF8;

DROP TABLE IF EXISTS user_contact;

CREATE TABLE user_contact (
                        `id` INT AUTO_INCREMENT,
                        `studentid` CHAR(32),
                        `friendid` CHAR(32),
                        PRIMARY KEY (id)
) CHARSET = UTF8;
