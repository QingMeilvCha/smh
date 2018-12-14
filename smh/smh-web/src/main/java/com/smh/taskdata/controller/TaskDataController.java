/**
 * @Title TaskDataController.java
 * @Package com.taskdata.controller
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:37:55
 * @version : V1.0
 */

package com.smh.taskdata.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName TaskDataController
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:37:55
 */
@Slf4j
@Api(tags = "任务数据controller")
@RestController
@RequestMapping("/taskData")
public class TaskDataController{

    @ApiOperation("接口1")
    @GetMapping(value = "/test")
    public String test(){
        return "success";
    }
}