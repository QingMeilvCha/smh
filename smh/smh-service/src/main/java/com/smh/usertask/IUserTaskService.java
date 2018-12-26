package com.smh.usertask;

import com.smh.taskdata.model.TaskDataEntity;
import com.smh.user.model.UserEntity;

import java.util.List;

/**
 * Created by dell on 2018/12/25.
 */
public interface IUserTaskService {

    void doUserTask(List<TaskDataEntity> taskDataEntities, UserEntity userEntity);
}
