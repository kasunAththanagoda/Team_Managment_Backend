package com.TMA.TeamManagmentApp.Dto;

import com.TMA.TeamManagmentApp.entity.ProjectEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class TasksDto {
    private ProjectEntity project;
    private int taskId;
    private String title;
    private String content;
    private String assignedTo;
    private String createdBy;
    private String createdDate;
    private String dueDate;
    private boolean activeStatus;
}
