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
import com.smh.usertask.IUserTaskService;
import com.smh.usertask.model.UserTaskEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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


    @ApiOperation("数据获取")
    @PostMapping
    public AdusResponse getDatas(TaskDataEntity taskDataEntity){
        if(!userTaskService.doUserTask(taskDataEntity)){
            return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"",null);
        }
        return new AdusResponse(SysConstants.ResponseCode.SUCCESS,"",null);
    }

}

