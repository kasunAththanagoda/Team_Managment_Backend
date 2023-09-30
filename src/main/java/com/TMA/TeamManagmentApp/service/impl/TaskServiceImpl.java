package com.TMA.TeamManagmentApp.service.impl;

import com.TMA.TeamManagmentApp.Dto.Request.TaskAddRequestDto;
import com.TMA.TeamManagmentApp.Dto.TasksDto;
import com.TMA.TeamManagmentApp.entity.TasksEntity;
import com.TMA.TeamManagmentApp.exception.NotFoundException;
import com.TMA.TeamManagmentApp.repo.ProjectRepo;
import com.TMA.TeamManagmentApp.repo.TaskRepo;
import com.TMA.TeamManagmentApp.service.TaskService;
import com.TMA.TeamManagmentApp.utils.mappers.TaskMappers;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private TaskMappers taskMappers;

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public String addTask(TaskAddRequestDto taskAddRequestDto) {

//        private ProjectEntity project;
//        private int taskId;
//        private String title;
//        private String content;
//        private String assignedTo;
//        private String createdBy;
//        private String createdDate;
//        private String dueDate;
//        private boolean activeStatus;

        TasksEntity entity = new TasksEntity(
                projectRepo.getReferenceById(taskAddRequestDto.getProject()),
                taskAddRequestDto.getTitle(),
                taskAddRequestDto.getContent(),
                taskAddRequestDto.getAssignedTo(),
                taskAddRequestDto.getCreatedBy(),
                taskAddRequestDto.getCreatedDate(),
                taskAddRequestDto.getDueDate(),
                taskAddRequestDto.isActiveStatus()
        );

        TasksEntity save = taskRepo.save(entity);
        //    return null;
        return "task saved with id "+save.getTaskId() ;
    }

    @Override
    public List<TasksDto> getTasks() {
        List<TasksEntity> tasksEntities=taskRepo.findAll();
         List<TasksDto> tasksDtos=taskMappers.entityListToDtoList(tasksEntities);
        return tasksDtos;
    }

    @Override
    public List<TasksDto> getTasksByUser(String userName,boolean activeStatus) {
        List<TasksEntity> tasksEntities=taskRepo.findByAssignedToEqualsAndActiveStatusEquals(userName,activeStatus);
        List<TasksDto> tasksDtos=taskMappers.entityListToDtoList(tasksEntities);
        return tasksDtos;
    }

    @Override
    public String switchStatus(int taskId) {
        if(taskRepo.existsById(taskId)){
            int taskStatus=taskRepo.getStatus(taskId);
            boolean taskStatuss=taskStatus==1 ? false : true;

            int updatedRows = taskRepo.updateActiveStatusByTaskIdNativeQuery(taskId, taskStatuss);

           // int x=taskRepo.setStatus(taskStatuss,taskId);
           // System.out.println(x);
            return "status changed";
        }else{
            throw new NotFoundException("id not found");
        }

    }
}
