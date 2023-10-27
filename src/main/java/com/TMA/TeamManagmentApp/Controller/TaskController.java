package com.TMA.TeamManagmentApp.Controller;

import com.TMA.TeamManagmentApp.Dto.Request.TaskAddRequestDto;
import com.TMA.TeamManagmentApp.Dto.Response.TaskgetResponseDto;
import com.TMA.TeamManagmentApp.Dto.TasksDto;
import com.TMA.TeamManagmentApp.entity.TasksEntity;
import com.TMA.TeamManagmentApp.service.TaskService;
import com.TMA.TeamManagmentApp.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tasks")
@CrossOrigin("*")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping(path = "/addTask")
    public ResponseEntity<StandardResponse> addTask(@RequestBody TaskAddRequestDto taskAddRequestDto){
        String message=taskService.addTask(taskAddRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/getTasks")
    public ResponseEntity<StandardResponse> getTasks(){
        List<TasksDto> tasks=taskService.getTasks();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",tasks),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/getTasksNew")
    public ResponseEntity<StandardResponse> getTasksnew(){
        List<TaskgetResponseDto> tasks=taskService.getTasksNew();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",tasks),
                HttpStatus.OK
        );
    }


    @GetMapping(path = "/getTasksByUser",params = {"user","activeStatus"})
    public ResponseEntity<StandardResponse> getTasksByUser(@RequestParam(value = "user") String userName,@RequestParam(value = "activeStatus") boolean activeStatus){
        List<TasksDto> tasks=taskService.getTasksByUser(userName,activeStatus);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",tasks),
                HttpStatus.OK
        );
    }

    @PutMapping(path = "/switchActiveStatus",params = {"taskId"})
    public ResponseEntity<StandardResponse> switchStatus(@RequestParam(value = "taskId") int taskId){
        String message=taskService.switchStatus(taskId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",message),
                HttpStatus.OK
        );
    }
}
