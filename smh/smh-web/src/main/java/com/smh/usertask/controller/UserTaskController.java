/**
 * @Title UserTaskController.java
 * @Package com.usertask.controller
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:37:05
 * @version : V1.0
 */

package com.smh.usertask.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.smh.response.AdusResponse;
import com.smh.shuizhun.model.LPointClass;
import com.smh.shuizhun.model.LineClass;
import com.smh.shuizhun.domain.Calculate;
import com.smh.shuizhun.model.Results;
import com.smh.shuizhun.result.CalculateResult;
import com.smh.sys.SysConstants;
import com.smh.usertask.IUserTaskService;
import com.smh.usertask.model.UserTaskEntity;
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
import java.util.List;
import java.util.UUID;


/**
 * @ClassName UserTaskController
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:37:05
 */
@Slf4j
@Api(tags = "用户任务controller")
@RestController
@RequestMapping("/userTask")
public class UserTaskController {

    @Autowired
    private IUserTaskService userTaskService;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private Calculate calculate;

    @ApiOperation("接收user_task数据")
    @PostMapping(value = "/recieveData")
    public AdusResponse getDatas(String param, HttpServletRequest request) throws Exception {
//        String token = tokenUtil.getToken(request);
        JSONObject jsonObject =(JSONObject) JSONObject.parse(param);
        String taskName = jsonObject.get("taskName").toString();
        String points = jsonObject.get("ControlPoints").toString();
        String lines = jsonObject.get("CurrentSegments").toString();
        String currPoints = jsonObject.get("CurrentPoints").toString();

        Gson gson = new Gson();
        List<LPointClass> ControlPoints = gson.fromJson(points,new TypeToken<List<LPointClass>>(){}.getType());
        List<LineClass> CurrentSegments=gson.fromJson(lines,new TypeToken<List<LineClass>>(){}.getType());
        List<LPointClass> CurrentPoints = gson.fromJson(currPoints,new TypeToken<List<LPointClass>>(){}.getType());

        calculate.doCaculateH(ControlPoints,CurrentPoints,CurrentSegments);
        calculate.doAdjustLevel(ControlPoints,CurrentPoints,CurrentSegments);
        CalculateResult calculateResult = calculate.getCalculateResult();


        String taskId = UUID.randomUUID().toString().replace("-","").substring(0,10);
        String pointDataId = UUID.randomUUID().toString().replace("-","").substring(0,10);
        String linrDataId = UUID.randomUUID().toString().replace("-","").substring(0,10);
        String resultId = UUID.randomUUID().toString().replace("-","").substring(0,10);

        UserTaskEntity userTaskEntity=new UserTaskEntity();
        userTaskEntity.setUserTaskId(taskId);
        userTaskEntity.setPointDataId(pointDataId);
        userTaskEntity.setLineDataId(linrDataId);
        userTaskEntity.setUserId("4");
        userTaskEntity.setResultId(resultId);
        userTaskEntity.setTaskName(taskName);
        userTaskEntity.setTaskType("水准网平差");

        String hvResultId = UUID.randomUUID().toString().replace("-","").substring(0,10);
        String alResultId = UUID.randomUUID().toString().replace("-","").substring(0,10);

        Results results=new Results();
        results.setHvResultId(hvResultId);
        results.setAlResultId(alResultId);
        results.setDerta(calculateResult.getDerta());
        //存储任务
        userTaskService.doUserTask(userTaskEntity,CurrentPoints,pointDataId,CurrentSegments,linrDataId,results,resultId
        ,calculateResult.getHVResults(),hvResultId,calculateResult.getALResults(),alResultId);
        return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"数据接收成功",calculateResult);
    }

    @ApiOperation("获取user_task数据")
    @GetMapping(value = "/getTaskByType")
    public AdusResponse getTaskByType(String taskType){
        List<UserTaskEntity> taskByType = userTaskService.getTaskByType(taskType);
        return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"任务数据获取成功",taskByType);
    }
}

