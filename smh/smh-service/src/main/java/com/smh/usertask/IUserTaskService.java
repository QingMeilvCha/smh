package com.smh.usertask;

import com.smh.taskdata.model.TaskDataEntity;

/**
 * Created by dell on 2018/12/25.
 */
public interface IUserTaskService {

    boolean doUserTask(TaskDataEntity taskDataEntity);
}
