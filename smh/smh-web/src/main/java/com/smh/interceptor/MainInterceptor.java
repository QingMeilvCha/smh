package com.smh.interceptor;

import com.smh.exception.LoginException;
import com.smh.utils.RedisUtils;
import javafx.fxml.LoadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhouyuhang on 2018/12/24.
 */
@Component
public class MainInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws LoginException {
        String token = request.getSession().getId();
        Object o = redisUtils.get(token);
        if(o!=null){
            return true;
        }else{
            throw new LoginException("登录异常，请重新登录！");
        }
    }
}
