/**
 * @Title UserController.java
 * @Package com.user.controller
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:28:51
 * @version : V1.0
 */

package com.smh.user.controller;


import com.smh.user.IUserService;
import com.smh.user.mapper.UserMapper;
import com.smh.user.model.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:28:51
 */
@Slf4j
@Api(tags = "用户controller")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private UserMapper userMapper;

    @ApiOperation("用户注册Controller")
    @PostMapping(value="/register")
    public String userRegister(UserEntity userEntity){
        //1、验证
        try {
            userEntity.CheckUserEntityParam();
        } catch (Exception e) {
            return e.getMessage();
        }
        //2、用户名是否存在
        UserEntity entity = userService.findUserByUserName(userEntity.getUserName());
        if(entity!=null){
            return "用户名已存在！";
        }else{
        //3、插入数据
            userService.insertUserEntity(userEntity);
            return "success";
        }
    }

    @ApiOperation("用户登录Controller")
    @PostMapping(value="/login")
    public String userLogin(UserEntity userEntity){
        //1、验证用户名和密码
        UserEntity user = userService.findUserEntityByUserNameAndPassword(userEntity);
        if(user!=null){
            return "success";
        }else{
            return "用户名或密码错误！";
        }
    }

    @ApiOperation("测试Controller")
    @GetMapping(value="/test")
    public String test(){
        Map<String,Object> param=new HashMap<String,Object>();
        param.put("userName","zhouyuhang");
        Integer integer = userMapper.selectCount(param);
        return integer+"";
    }
}