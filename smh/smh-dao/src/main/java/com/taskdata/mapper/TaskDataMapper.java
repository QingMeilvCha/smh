/**
 * @Title TaskDataMapper.java
 * @Package com.taskdata.mapper
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-14 16:48:21
 * @version : V1.0
 */

package com.taskdata.mapper;

import com.taskdata.model.TaskDataEntity;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TaskDataMapper
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-14 16:48:21
 */
public interface TaskDataMapper{

    void insert(TaskDataEntity taskDataEntity);

    void update(TaskDataEntity taskDataEntity);

    TaskDataEntity selectEntity(Map<String, Object> param);

    void insertBatch(List<TaskDataEntity> list);

    List<TaskDataEntity> selectEntities(Map<String, Object> param);
}
