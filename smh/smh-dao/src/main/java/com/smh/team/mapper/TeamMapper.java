/**
 * @Title TeamMapper.java
 * @Package com.team.mapper
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:38:09
 * @version : V1.0
 */

package com.smh.team.mapper;


import com.smh.team.model.TeamEntity;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TeamMapper
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:38:09
 */
public interface TeamMapper {

    void insert(TeamEntity teamEntity);

    void update(TeamEntity teamEntity);

    TeamEntity selectEntity(Map<String, Object> param);

    void insertBatch(List<TeamEntity> list);

    List<TeamEntity> selectEntities(Map<String, Object> param);
}
