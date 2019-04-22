/**
 * @Title TaskDataController.java
 * @Package com.taskdata.controller
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:37:55
 * @version : V1.0
 */

package com.smh.taskdata.controller;


import com.smh.hvresult.mapper.HvResultMapper;
import com.smh.line.mapper.LineClassMapper;
import com.smh.point.mapper.LPointClassMapper;
import com.smh.shuizhun.model.HVResults;
import com.smh.shuizhun.model.LPointClass;
import com.smh.shuizhun.model.LineClass;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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

    @Autowired
    private LPointClassMapper lPointClassMapper;
    @Autowired
    private LineClassMapper lineClassMapper;
    @Autowired
    private HvResultMapper hvResultMapper;

    @ApiOperation("接口1")
    @GetMapping(value = "/test")
    public String test(){
        List<HVResults> hvResults = hvResultMapper.selectEntity();
        return "success";
    }
}