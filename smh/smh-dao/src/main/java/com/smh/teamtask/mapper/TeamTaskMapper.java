/**
 * @Title TeamTaskMapper.java
 * @Package com.teamtask.mapper
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:36:46
 * @version : V1.0
 */

package com.smh.teamtask.mapper;


import com.smh.teamtask.model.TeamTaskEntity;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TeamTaskMapper
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:36:46
 */
public interface TeamTaskMapper  {

    void insert(TeamTaskEntity taskDataEntity);

    void update(TeamTaskEntity taskDataEntity);

    TeamTaskEntity selectEntity(Map<String, Object> param);

    void insertBatch(List<TeamTaskEntity> list);

    List<TeamTaskEntity> selectEntities(Map<String, Object> param);
}
