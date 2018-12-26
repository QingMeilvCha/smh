package com.smh.utils;

import com.smh.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhouyuhang on 2018/12/26.
 */
@Component
public class TokenUtil {

    @Autowired
    private RedisUtils redisUtils;

    public String getToken(HttpServletRequest request){
        return request.getSession().getId();
    }

    public UserEntity getUserByToken(String token){
        return (UserEntity) redisUtils.get(token);
    }

    public UserEntity getUserByToken(HttpServletRequest request){
        String token = getToken(request);
        return (UserEntity) redisUtils.get(token);
    }

    public void removeToken(String token){
        redisUtils.romoveValue(token);
    }

}
