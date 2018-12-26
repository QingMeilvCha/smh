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
import com.smh.user.mapper.UserMapper;
import com.smh.user.model.UserEntity;
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
    private RedisUtils redisUtils;
    @Autowired
    private TokenUtil tokenUtil;

    @ApiOperation("用户注册Controller")
    @PostMapping(value="/register")
    public AdusResponse userRegister(UserEntity userEntity){
        //1、验证
        try {
            userEntity.CheckUserEntityParam();
        } catch (Exception e) {
            return new AdusResponse(SysConstants.ResponseCode.SUCCESS,e.getMessage(),null);
        }
        //2、用户名是否存在
        UserEntity entity = userService.findUserByUserName(userEntity.getUserName());
        if(entity!=null){
            return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"用户名已存在",null);
        }else{
        //3、插入数据
            userService.insertUserEntity(userEntity);
            return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"success",null);
        }
    }

    @ApiOperation("用户登录Controller")
    @PostMapping(value="/login")
    public AdusResponse userLogin(UserEntity userEntity,HttpServletRequest request){

        String token = tokenUtil.getToken(request);
        UserEntity u = (UserEntity)redisUtils.get(token);
        if(u!=null){
            return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"登录成功",null);
        }else{
            UserEntity user = userService.findUserEntityByUserNameAndPassword(userEntity);
            if(user!=null){
                redisUtils.set(token,user,60*30);
                return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"登录成功",null);
            }else{
                return new AdusResponse(SysConstants.ResponseCode.FAIL,"用户名或密码错误",null);
            }
        }
    }

    @ApiOperation("用户注销Controller")
    @GetMapping(value="/logout")
    public AdusResponse logout(HttpServletRequest request){
        String token = tokenUtil.getToken(request);
        redisUtils.romoveValue(token);
        return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"注销成功",null);
    }

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

    @ApiOperation("测试虚拟路劲配置")
    @GetMapping(value="/testpath")
    public AdusResponse testpath() throws IOException {

       // 新建文件输入流并对它进行缓冲
        FileInputStream input = new FileInputStream("/image/a1.jpg");
        BufferedInputStream inBuff=new BufferedInputStream(input);

        // 新建文件输出流并对它进行缓冲
        FileOutputStream output = new FileOutputStream("/image/a1.jpg");
        BufferedOutputStream outBuff=new BufferedOutputStream(output);

        // 缓冲数组
        byte[] b = new byte[1024 * 5];
        int len;
        while ((len =inBuff.read(b)) != -1) {
            outBuff.write(b, 0, len);
        }
        // 刷新此缓冲的输出流
        outBuff.flush();

        //关闭流
        inBuff.close();
        outBuff.close();
        output.close();
        input.close();
        return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"success",null);
    }
}