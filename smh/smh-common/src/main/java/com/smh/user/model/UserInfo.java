package com.smh.user.model;

import lombok.Data;

/**
 * Created by zhouyuhang on 2019/1/9.
 */
@Data
public class UserInfo {

    private Long userId;

    private String userName;

    private String account;

    private String password;
}
