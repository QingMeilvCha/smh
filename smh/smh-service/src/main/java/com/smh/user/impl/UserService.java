package com.smh.user.impl;

import com.smh.user.IUserService;
import com.smh.user.mapper.UserMapper;
import com.smh.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
    public Map<String,Object> findUserEntityByUserNameAndPassword(UserEntity userEntity) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        UserEntity entity = userMapper.selectEntity(userEntity);
        if(entity!=null){
            map.put("body",entity);
        }
        return map;
    }
}
