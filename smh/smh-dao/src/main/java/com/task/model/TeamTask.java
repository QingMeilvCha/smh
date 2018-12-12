package com.task.model;

import lombok.Data;

import java.util.Date;

@Data
public class TeamTask {
    private Integer teamTaskId;

    private Integer teamId;

    private Integer dataId;

    private String taskType;

    private Date creatTime;

    private String mark;
}