package mapper;


import model.UserTeam;
import model.UserTeamExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserTeamMapper {
    int countByExample(UserTeamExample example);

    int deleteByExample(UserTeamExample example);

    int deleteByPrimaryKey(Integer userTeamId);

    int insert(UserTeam record);

    int insertSelective(UserTeam record);

    List<UserTeam> selectByExample(UserTeamExample example);

    UserTeam selectByPrimaryKey(Integer userTeamId);

    int updateByExampleSelective(@Param("record") UserTeam record, @Param("example") UserTeamExample example);

    int updateByExample(@Param("record") UserTeam record, @Param("example") UserTeamExample example);

    int updateByPrimaryKeySelective(UserTeam record);

    int updateByPrimaryKey(UserTeam record);
}