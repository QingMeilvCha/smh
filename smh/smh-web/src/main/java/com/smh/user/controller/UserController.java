/**
 * @Title UserController.java
 * @Package com.user.controller
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:28:51
 * @version : V1.0
 */

package com.smh.user.controller;


import com.smh.user.model.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName UserController
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:28:51
 */
@Slf4j
@Api(tags = "用户controller")
@Controller
@RequestMapping("/user")
public class UserController {

    @ApiOperation("接口1")
    @PostMapping(value="/register")
    public void userRegister(UserEntity userEntity){

    }
}