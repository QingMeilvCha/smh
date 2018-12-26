package com.smh.dataprocess;

import com.smh.taskdata.model.TaskDataEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhouyuhang on 2018/12/26.
 */
@Component
public class ShuiZhunTools {

    /**
     * 计算每一个测站数据
     * @param taskDataEntities
     * @return
     */
    public List<TaskDataEntity> shuiZhunCeZhan(List<TaskDataEntity> taskDataEntities){
        taskDataEntities.forEach(entity->
        {
            //每一测站数据处理逻辑
            entity.setPostDistance(entity.getPostDistanceUp().subtract(entity.getPostDistanceBottm()));
            entity.setPreDistance(entity.getPreDistanceUo().subtract(entity.getPreDistanceBottm()));
            entity.setDistanceReduce(entity.getPostDistance().subtract(entity.getPreDistance()));

            //未完成
        });
        return taskDataEntities;
    }
}
