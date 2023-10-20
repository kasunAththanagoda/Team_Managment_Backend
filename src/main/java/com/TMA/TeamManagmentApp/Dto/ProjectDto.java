package com.TMA.TeamManagmentApp.Dto;


import com.TMA.TeamManagmentApp.entity.TasksEntity;
//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectDto {
    //private Set<TasksEntity> tasksEntitySet;
    private int projectId;
    private String projectName;
    private String startingDate ;
    private String dueDate ;
    private String createdBy;
    private String teamMembers;
    private String information;
    private boolean activeStatus;

}
