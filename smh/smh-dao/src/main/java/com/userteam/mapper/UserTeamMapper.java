/**
 * @Title UserTeamMapper.java
 * @Package com.userteam.mapper
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:37:40
 * @version : V1.0
 */

package com.userteam.mapper;

import com.userteam.model.UserTeamEntity;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserTeamMapper
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:37:40
 */
public interface UserTeamMapper {

    void insert(UserTeamEntity taskDataEntity);

    void update(UserTeamEntity taskDataEntity);

    UserTeamEntity selectEntity(Map<String, Object> param);

    void insertBatch(List<UserTeamEntity> list);

    List<UserTeamEntity> selectEntities(Map<String, Object> param);
}
