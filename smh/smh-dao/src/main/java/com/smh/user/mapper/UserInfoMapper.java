package com.smh.user.mapper;


import com.smh.user.model.UserInfo;

import java.util.Map;

/**
 * Created by zhouyuhang on 2019/1/9.
 */
public interface UserInfoMapper {

    void insert(UserInfo userInfo);

    UserInfo selectEntity(Map<String,Object> param);
}
