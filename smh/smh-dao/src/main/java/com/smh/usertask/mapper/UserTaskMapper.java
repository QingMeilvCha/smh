/**
 * @Title UserTaskMapper.java
 * @Package com.usertask.mapper
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:37:05
 * @version : V1.0
 */

package com.smh.usertask.mapper;


import com.smh.usertask.model.UserTaskEntity;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserTaskMapper
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:37:05
 */
public interface UserTaskMapper {

    void insert(UserTaskEntity taskDataEntity);

    void update(UserTaskEntity taskDataEntity);

    UserTaskEntity selectEntity(Map<String, Object> param);

    void insertBatch(List<UserTaskEntity> list);

    List<UserTaskEntity> selectEntities(Map<String, Object> param);
}
