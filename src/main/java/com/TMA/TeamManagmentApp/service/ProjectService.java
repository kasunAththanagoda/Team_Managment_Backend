package com.TMA.TeamManagmentApp.service;

import com.TMA.TeamManagmentApp.Dto.ProjectDto;
import com.TMA.TeamManagmentApp.Dto.Request.ProjectAddRequestDto;

import java.util.List;

public interface ProjectService {
    String addProject(ProjectAddRequestDto projectAddRequestDto);

    List<ProjectDto> getProjects();
}
