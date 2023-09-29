package com.TMA.TeamManagmentApp.utils.mappers;

import com.TMA.TeamManagmentApp.Dto.ProjectDto;
import com.TMA.TeamManagmentApp.Dto.Request.ProjectAddRequestDto;
import com.TMA.TeamManagmentApp.Dto.TasksDto;
import com.TMA.TeamManagmentApp.entity.ProjectEntity;
import com.TMA.TeamManagmentApp.entity.TasksEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMappers {
    List<TasksDto> entityListToDtoList(List<TasksEntity> tasksEntities);
}

