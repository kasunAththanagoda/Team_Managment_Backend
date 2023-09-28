package com.TMA.TeamManagmentApp.service.impl;

import com.TMA.TeamManagmentApp.Dto.Request.ProjectAddRequestDto;
import com.TMA.TeamManagmentApp.entity.ProjectEntity;
import com.TMA.TeamManagmentApp.repo.ProjectRepo;
import com.TMA.TeamManagmentApp.service.ProjectService;
import com.TMA.TeamManagmentApp.utils.mappers.ProjectMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMappers projectMappers;

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public String addProject(ProjectAddRequestDto projectAddRequestDto) {
        ProjectEntity projectEntity=projectMappers.dtoToEntity(projectAddRequestDto);
        projectEntity.setActiveStatus(true);
        ProjectEntity savedEntity = projectRepo.save(projectEntity);
        return "project "+savedEntity.getProjectName()+" with id "+savedEntity.getProjectId();
    }
}
