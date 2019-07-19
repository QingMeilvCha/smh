/**
 * @Title UserController.java
 * @Package com.user.controller
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:28:51
 * @version : V1.0
 */

package com.smh.user.controller;


import com.smh.response.AdusResponse;
import com.smh.sys.SysConstants;
import com.smh.user.IUserService;
import com.smh.user.mapper.UserInfoMapper;
import com.smh.user.mapper.UserMapper;
import com.smh.user.model.UserEntity;
import com.smh.user.model.UserInfo;
import com.smh.utils.RedisUtils;
import com.smh.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
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
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private TokenUtil tokenUtil;

    @ApiOperation("测试Controller")
    @GetMapping(value="/test")
    public String test(){
        Map<String,Object> param=new HashMap<String,Object>();
        param.put("userName","zhouyuhang");
        Integer integer = userMapper.selectCount(param);
        return integer+"";
    }

    @ApiOperation("测试redis插入数据 Controller")
    @GetMapping(value="/redis")
    public AdusResponse test1(UserEntity userEntity,HttpServletRequest request){
        String token = tokenUtil.getToken(request);
        redisUtils.set(token,userEntity,60*30);
        return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"success",null);
    }

    @ApiOperation("测试redis查询数据 Controller")
    @GetMapping(value="/redis2")
    public AdusResponse test2(HttpServletRequest request){
        String token = tokenUtil.getToken(request);
        UserEntity userEntity = (UserEntity)redisUtils.get(token);
        return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"success",userEntity);
    }

    @ApiOperation("测试sharding 插入数据 Controller")
    @GetMapping(value="/shardingInsert")
    public AdusResponse shardingInsert(UserInfo userInfo){
        userInfoMapper.insert(userInfo);
        return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"success",null);
    }

    @ApiOperation("测试sharding 查询数据 Controller")
    @GetMapping(value="/shardingSelect")
    public AdusResponse shardingSelect(Long userId){
        Map<String,Object> param=new HashMap<String, Object>();
        param.put("userId",userId);
        UserInfo userInfo = userInfoMapper.selectEntity(param);
        return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"success",userInfo);
    }
}