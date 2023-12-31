package com.TMA.TeamManagmentApp.utils.mappers;

import com.TMA.TeamManagmentApp.Dto.ProjectDto;
import com.TMA.TeamManagmentApp.Dto.Request.ProjectAddRequestDto;
import com.TMA.TeamManagmentApp.entity.ProjectEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMappers {
    ProjectEntity dtoToEntity(ProjectAddRequestDto projectAddRequestDto);

    List<ProjectDto> entityListToDtoList(List<ProjectEntity> projectEntities);
}
