package com.smh.usertask.impl;

import com.smh.dataprocess.ShuiZhunTools;
import com.smh.sys.SysConstants;
import com.smh.taskdata.mapper.TaskDataMapper;
import com.smh.taskdata.model.TaskDataEntity;
import com.smh.user.model.UserEntity;
import com.smh.usertask.IUserTaskService;
import com.smh.usertask.mapper.UserTaskMapper;
import com.smh.usertask.model.UserTaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by zhouyuhang on 2018/12/25.
 */
@Service
public class UserTaskService implements IUserTaskService{

    @Autowired
    private UserTaskMapper userTaskMapper;
    @Autowired
    private TaskDataMapper taskDataMapper;
    @Autowired
    private ShuiZhunTools shuiZhunTools;

    @Override
    public void doUserTask(List<TaskDataEntity> taskDataEntities, UserEntity userEntity){
        //1、数据处理
        List<TaskDataEntity> list = shuiZhunTools.shuiZhunCeZhan(taskDataEntities);
        //2、插入数据表
        //a 生成data_id
        String dataId = UUID.randomUUID().toString();
        Integer userId = userEntity.getUserId();

        UserTaskEntity userTaskEntity=new UserTaskEntity();
        userTaskEntity.setUserId(userId);
        userTaskEntity.setDataId(dataId);
        userTaskEntity.setTaskType(SysConstants.SmType.SHUIZHUN);
        //插入user_task表
        //插入task_data表
        insertUserTaskAndTaskData(userTaskEntity,list);
    }

    @Transactional
    public void insertUserTaskAndTaskData(UserTaskEntity userTaskEntity,List<TaskDataEntity> list){
        userTaskMapper.insert(userTaskEntity);
        taskDataMapper.insertBatch(list);
    }

}
