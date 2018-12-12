package com.task.mapper;


import com.task.model.TeamTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamTaskMapper {
    int countByExample(TeamTaskExample example);

    int deleteByExample(TeamTaskExample example);

    int deleteByPrimaryKey(Integer teamTaskId);

    int insert(TeamTask record);

    int insertSelective(TeamTask record);

    List<TeamTask> selectByExample(TeamTaskExample example);

    TeamTask selectByPrimaryKey(Integer teamTaskId);

    int updateByExampleSelective(@Param("record") TeamTask record, @Param("example") TeamTaskExample example);

    int updateByExample(@Param("record") TeamTask record, @Param("example") TeamTaskExample example);

    int updateByPrimaryKeySelective(TeamTask record);

    int updateByPrimaryKey(TeamTask record);
}