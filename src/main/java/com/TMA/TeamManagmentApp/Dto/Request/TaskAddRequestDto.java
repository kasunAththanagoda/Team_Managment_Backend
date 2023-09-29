package com.TMA.TeamManagmentApp.Dto.Request;

import com.TMA.TeamManagmentApp.entity.ProjectEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskAddRequestDto {
    private int project;
    //private int taskId;
    private String title;
    private String content;
    private String assignedTo;
    private String createdBy;
    private String createdDate;
    private String dueDate;
    private boolean activeStatus;
}
