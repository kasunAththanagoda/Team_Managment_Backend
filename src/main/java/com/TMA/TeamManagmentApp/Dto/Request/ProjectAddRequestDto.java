package com.TMA.TeamManagmentApp.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectAddRequestDto {
    //private Set<TasksEntity> tasksEntitySet;
    //private int projectId;
    private String projectName;
    private String startingDate ;
    private String dueDate ;
    private String createdBy;
    private String teamMembers;
    private String information;
    //private boolean activeStatus;
}
