package com.smh.usertask;

import com.smh.shuizhun.model.*;
import com.smh.taskdata.model.TaskDataEntity;
import com.smh.user.model.UserEntity;
import com.smh.usertask.model.UserTaskEntity;

import java.util.List;

/**
 * Created by dell on 2018/12/25.
 */
public interface IUserTaskService {

    void doUserTask(UserTaskEntity userTaskEntity,List<LPointClass> CurrentPoints,String pointDataId,List<LineClass> CurrentSegments,String linrDataId,Results results,String resultId,
                    List<HVResults> hvResults,String hvResultId,List<ALResults> alResults,String alResultId);

    List<UserTaskEntity> getTaskByType(String taskType);

    void insert(UserTaskEntity userTaskEntity);


    void insertBatchPoints(List<LPointClass> lPointClasses,String id);

    void insertBatchLines(List<LineClass> lineClasses,String id);

    void insertBatchHvResult(List<HVResults> hvResults,String id);

    void insertBatchAlResult(List<ALResults> alResults,String id);

    void insertResult(Results result,String id);
}
