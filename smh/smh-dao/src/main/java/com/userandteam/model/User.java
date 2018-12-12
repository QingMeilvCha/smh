package com.userandteam.model;

import lombok.Data;

@Data
public class User {
    private Integer userId;

    private String userName;

    private String sex;

    private Integer age;

    private String email;

    private String phoneNumber;

    private String mark;
}