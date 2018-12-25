package com.smh.user;


import com.smh.user.model.UserEntity;

import java.util.Map;

/**
 * Created by dell on 2018/12/17.
 */
public interface IUserService {

    UserEntity findUserByUserName(String userName);

    void insertUserEntity(UserEntity userEntity);

    UserEntity findUserEntityByUserNameAndPassword(UserEntity userEntity);
}
