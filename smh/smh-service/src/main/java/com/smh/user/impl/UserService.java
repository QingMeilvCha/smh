package com.smh.user.impl;

import com.smh.user.IUserService;
import com.smh.user.mapper.UserMapper;
import com.smh.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2018/12/17.
 */
@Service
public class UserService implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity findUserByUserName(String userName) {
        return userMapper.findUserEntityByUserName(userName);
    }

    @Override
    public void insertUserEntity(UserEntity userEntity) {
        userMapper.insert(userEntity);
    }

    @Override
    public UserEntity findUserEntityByUserNameAndPassword(UserEntity userEntity) {
        return userMapper.selectEntity(userEntity);
    }
}
