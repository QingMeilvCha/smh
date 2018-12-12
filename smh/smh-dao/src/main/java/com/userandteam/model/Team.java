package com.userandteam.model;

import lombok.Data;

import java.util.Date;

@Data
public class Team {
    private Integer teamId;

    private String teamName;

    private String summary;

    private Date creatTime;

    private String mark;
}