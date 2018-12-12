package model;

import java.util.Date;

public class TeamTask {
    private Integer teamTaskId;

    private Integer teamId;

    private Integer dataId;

    private String taskType;

    private Date creatTime;

    private String mark;

    public Integer getTeamTaskId() {
        return teamTaskId;
    }

    public void setTeamTaskId(Integer teamTaskId) {
        this.teamTaskId = teamTaskId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}