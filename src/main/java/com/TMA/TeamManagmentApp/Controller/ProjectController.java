package com.TMA.TeamManagmentApp.Controller;

import com.TMA.TeamManagmentApp.Dto.ProjectDto;
import com.TMA.TeamManagmentApp.Dto.Request.ProjectAddRequestDto;
import com.TMA.TeamManagmentApp.Dto.Request.ProjectUpdateRequestDto;
import com.TMA.TeamManagmentApp.service.ProjectService;
import com.TMA.TeamManagmentApp.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/projects")
@CrossOrigin()
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(path = "/addProject")
    public ResponseEntity<StandardResponse> addProject(@RequestBody ProjectAddRequestDto projectAddRequestDto) {
        String message = projectService.addProject(projectAddRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/getProjects")
    public ResponseEntity<StandardResponse> getProjects() {
        List<ProjectDto> projectDtoList = projectService.getProjects();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", projectDtoList),
                HttpStatus.OK
        );
    }

    @PutMapping(path = "/updateProject")
    public ResponseEntity<StandardResponse> updateProject(@RequestBody ProjectUpdateRequestDto projectUpdateRequestDto) {
        String message = projectService.updateProject(projectUpdateRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", message),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/deleteProject", params = "projectId")
    public ResponseEntity<StandardResponse> deleteProject ( @RequestParam(value = "projectId") int projectId){
        String message=projectService.deleteProjet(projectId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", message),
                HttpStatus.OK
        );
    }

}
