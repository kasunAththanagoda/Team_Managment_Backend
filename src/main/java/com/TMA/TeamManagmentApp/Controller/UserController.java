package com.TMA.TeamManagmentApp.Controller;

import com.TMA.TeamManagmentApp.Dto.Request.UserAddRequestDto;
import com.TMA.TeamManagmentApp.Service.UserService;
import com.TMA.TeamManagmentApp.Utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> addUser(@RequestBody UserAddRequestDto userAddRequestDto){

        String message=userService.addUSer(userAddRequestDto);


        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",message),
                HttpStatus.OK
        );
    }
}
