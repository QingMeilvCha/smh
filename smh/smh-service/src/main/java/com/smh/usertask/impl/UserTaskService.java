package com.smh.usertask.impl;

import com.smh.taskdata.mapper.TaskDataMapper;
import com.smh.taskdata.model.TaskDataEntity;
import com.smh.usertask.IUserTaskService;
import com.smh.usertask.mapper.UserTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2018/12/25.
 */
@Service
public class UserTaskService implements IUserTaskService{

    @Autowired
    private UserTaskMapper userTaskMapper;
    @Autowired
    private TaskDataMapper taskDataMapper;

    /**
     *
     */
    public boolean doUserTask(TaskDataEntity taskDataEntity){


        //1、接收到数据
        //2、数据处理
        //3、插入数据表
        return true;
    }

}
