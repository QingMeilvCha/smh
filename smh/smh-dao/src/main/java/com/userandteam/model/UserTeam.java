package com.userandteam.model;

import lombok.Data;

@Data
public class UserTeam {
    private Integer userTeamId;

    private Integer userId;

    private Integer teamId;

    private String role;

    private String mark;
}