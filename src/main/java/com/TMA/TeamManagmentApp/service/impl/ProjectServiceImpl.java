package com.TMA.TeamManagmentApp.service.impl;

import com.TMA.TeamManagmentApp.Dto.ProjectDto;
import com.TMA.TeamManagmentApp.Dto.Request.ProjectAddRequestDto;
import com.TMA.TeamManagmentApp.Dto.Request.ProjectUpdateRequestDto;
import com.TMA.TeamManagmentApp.entity.ProjectEntity;
import com.TMA.TeamManagmentApp.exception.NotFoundException;
import com.TMA.TeamManagmentApp.repo.ProjectRepo;
import com.TMA.TeamManagmentApp.service.ProjectService;
import com.TMA.TeamManagmentApp.utils.mappers.ProjectMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ProjectDto> getProjects() {
        List<ProjectEntity> projectEntities=projectRepo.findAll();
        List<ProjectDto> projectDtoList=projectMappers.entityListToDtoList(projectEntities);
        return projectDtoList;
    }

    @Override
    public String updateProject(ProjectUpdateRequestDto projectUpdateRequestDto) {
        Optional<ProjectEntity> byId = projectRepo.findById(projectUpdateRequestDto.getProjectId());
        if(byId.isPresent()){
            byId.get().setProjectName(projectUpdateRequestDto.getProjectName());
            byId.get().setStartingDate(projectUpdateRequestDto.getStartingDate());
            byId.get().setDueDate(projectUpdateRequestDto.getDueDate());
            byId.get().setCreatedBy(projectUpdateRequestDto.getCreatedBy());
            byId.get().setTeamMembers(projectUpdateRequestDto.getTeamMembers());
            byId.get().setInformation(projectUpdateRequestDto.getInformation());
            byId.get().setActiveStatus(projectUpdateRequestDto.isActiveStatus());

            ProjectEntity save = projectRepo.save(byId.get());
            return "project updated";
        }else{
            throw new NotFoundException("id not found");
        }
    }

    @Override
    public String deleteProjet(int projectId) {
        if(projectRepo.existsById(projectId)){
            projectRepo.deleteById(projectId);
            return "project deleted";
        }else{
            throw new NotFoundException("id not found");
        }
    }


}