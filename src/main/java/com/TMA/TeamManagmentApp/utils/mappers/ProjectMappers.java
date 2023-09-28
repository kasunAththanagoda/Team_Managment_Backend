package com.TMA.TeamManagmentApp.utils.mappers;

import com.TMA.TeamManagmentApp.Dto.Request.ProjectAddRequestDto;
import com.TMA.TeamManagmentApp.entity.ProjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMappers {
    ProjectEntity dtoToEntity(ProjectAddRequestDto projectAddRequestDto);
}
