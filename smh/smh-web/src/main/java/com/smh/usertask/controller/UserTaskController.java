/**
 * @Title UserTaskController.java
 * @Package com.usertask.controller
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:37:05
 * @version : V1.0
 */

package com.smh.usertask.controller;

import com.smh.response.AdusResponse;
import com.smh.sys.SysConstants;
import com.smh.taskdata.model.TaskDataEntity;
import com.smh.user.model.UserEntity;
import com.smh.usertask.IUserTaskService;
import com.smh.usertask.model.UserTaskEntity;
import com.smh.utils.RedisUtils;
import com.smh.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


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

    @ApiOperation("获取user_task数据")
    @PostMapping
    public AdusResponse getDatas(List<TaskDataEntity> taskDataEntities, HttpServletRequest request){
        String token = tokenUtil.getToken(request);
        UserEntity user = (UserEntity)redisUtils.get(token);
        userTaskService.doUserTask(taskDataEntities,user);
        return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"",null);
    }

}

