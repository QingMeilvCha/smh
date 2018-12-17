/**
 * @Title UserMapper.java
 * @Package com.user.mapper
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:28:51
 * @version : V1.0
 */

package com.smh.user.mapper;


import com.smh.user.model.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserMapper
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:28:51
 */
public interface UserMapper {

    void insert(UserEntity userEntity);

    void update(UserEntity userEntity);

    UserEntity selectEntity(UserEntity userEntity);

    void insertBatch(List<UserEntity> list);

    List<UserEntity> selectEntities(Map<String, Object> param);

    UserEntity findUserEntityByUserName(String userName);
    Integer selectCount(Map<String, Object> param);
}
