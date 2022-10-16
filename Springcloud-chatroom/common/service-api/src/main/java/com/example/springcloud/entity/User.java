package com.example.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private long uid;
    private String name;
    private String birth;
    private int age;
    private String avatar;
    private String password;
    private String role;
    private int student_id;
}
