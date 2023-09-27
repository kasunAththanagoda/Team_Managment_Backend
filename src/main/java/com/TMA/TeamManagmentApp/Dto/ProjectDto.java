package com.TMA.TeamManagmentApp.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectDto {
    //private Set<TasksEntity> tasksEntitySet;
    private int projectId;
    private String projectName;
    private String startingDate ;
    private String createdBy;
    private String teamMembers;
    private boolean activeStatus;
}
