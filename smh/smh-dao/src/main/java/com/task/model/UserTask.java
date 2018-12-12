package com.task.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserTask {
    private Integer userTaskId;

    private Integer userId;

    private Integer dataId;

    private String taskType;

    private Date creatTime;

    private String mark;

}