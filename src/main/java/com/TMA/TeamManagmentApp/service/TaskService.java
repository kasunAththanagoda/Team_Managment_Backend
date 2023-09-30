package com.TMA.TeamManagmentApp.service;

import com.TMA.TeamManagmentApp.Dto.Request.TaskAddRequestDto;
import com.TMA.TeamManagmentApp.Dto.TasksDto;

import java.util.List;

public interface TaskService {
    String addTask(TaskAddRequestDto taskAddRequestDto);

    List<TasksDto> getTasks();

    List<TasksDto> getTasksByUser(String userName,boolean activeStatus);

    String switchStatus(int taskId);
}
