package com.smh.usertask.impl;

import com.smh.alresult.mapper.AlResultMapper;
import com.smh.dataprocess.ShuiZhunTools;
import com.smh.hvresult.mapper.HvResultMapper;
import com.smh.line.mapper.LineClassMapper;
import com.smh.point.mapper.LPointClassMapper;
import com.smh.result.mapper.ResultMapper;
import com.smh.shuizhun.model.*;
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
    @Autowired
    private LPointClassMapper pointClassMapper;
    @Autowired
    private LineClassMapper lineClassMapper;
    @Autowired
    private HvResultMapper hvResultMapper;
    @Autowired
    private AlResultMapper alResultMapper;
    @Autowired
    private ResultMapper resultMapper;

    @Transactional
    @Override
    public void doUserTask(UserTaskEntity userTaskEntity, List<LPointClass> CurrentPoints, String pointDataId, List<LineClass> CurrentSegments, String linrDataId, Results results, String resultId, List<HVResults> hvResults, String hvResultId, List<ALResults> alResults, String alResultId) {
        insert(userTaskEntity);
        insertBatchPoints(CurrentPoints,pointDataId);
        insertBatchLines(CurrentSegments,linrDataId);
        insertResult(results,resultId);
        insertBatchHvResult(hvResults,hvResultId);
        insertBatchAlResult(alResults,alResultId);
    }


    @Override
    public List<UserTaskEntity> getTaskByType(String taskType) {
        return userTaskMapper.selectTasksByType(taskType);
    }

    @Override
    public void insert(UserTaskEntity userTaskEntity) {
        userTaskMapper.insert(userTaskEntity);
    }

    @Override
    public void insertBatchPoints(List<LPointClass> lPointClasses,String id) {
        lPointClasses.forEach(e->{
            e.setPointDataId(id);
        });
        pointClassMapper.insertBatch(lPointClasses);
    }

    @Override
    public void insertBatchLines(List<LineClass> lineClasses,String id) {
        lineClasses.forEach(e -> {
            e.setLineDataId(id);
        });
        lineClassMapper.insertBatch(lineClasses);
    }

    @Override
    public void insertBatchHvResult(List<HVResults> hvResults,String id) {
        hvResults.forEach(e->{
            e.setHvResultId(id);
        });
        hvResultMapper.insertBatch(hvResults);
    }

    @Override
    public void insertBatchAlResult(List<ALResults> alResults,String id){
        alResults.forEach(e -> {
            e.setAlResultId(id);
        });
        alResultMapper.insertBatch(alResults);
    }

    @Override
    public void insertResult(Results result,String id) {
        result.setResultId(id);
        resultMapper.insert(result);
    }
}
