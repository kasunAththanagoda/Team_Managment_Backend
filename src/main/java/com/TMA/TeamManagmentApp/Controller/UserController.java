package com.TMA.TeamManagmentApp.Controller;

import com.TMA.TeamManagmentApp.Dto.Request.UserAddRequestDto;
import com.TMA.TeamManagmentApp.Dto.Request.UserLoginRequestDto;
import com.TMA.TeamManagmentApp.Dto.Request.UserUpdateRequestDto;
import com.TMA.TeamManagmentApp.Dto.Response.Paginated.PaginatedUserGetResponseDto;
import com.TMA.TeamManagmentApp.Dto.Response.UserByNameResponseDto;
import com.TMA.TeamManagmentApp.Dto.Response.UserGetResponseDto;
import com.TMA.TeamManagmentApp.Dto.securityDto.JwtRequest;
import com.TMA.TeamManagmentApp.Dto.securityDto.JwtResponse;
import com.TMA.TeamManagmentApp.service.UserSecurityService;
import com.TMA.TeamManagmentApp.service.UserService;
import com.TMA.TeamManagmentApp.utils.StandardResponse;
import com.TMA.TeamManagmentApp.utils.securityUtils.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/saveUser")
    public ResponseEntity<StandardResponse> addUser(@RequestBody UserAddRequestDto userAddRequestDto) {
        String message = userService.addUSer(userAddRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/getPaginatedUsers", params = {"page", "size"})
    public ResponseEntity<StandardResponse> getUsers(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        PaginatedUserGetResponseDto userGetResponseDtos = userService.getUsers(page, size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", userGetResponseDtos),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/getAllUsers")
    public ResponseEntity<StandardResponse> getUsersWithoutPagination() {
        List<UserGetResponseDto> userGetResponseDtos = userService.getUsersWithoutPagination();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", userGetResponseDtos),
                HttpStatus.OK
        );
    }

    @PostMapping(path = "/login")
    public ResponseEntity<StandardResponse> loginUser(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        String message = userService.loginUser(userLoginRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", message),
                HttpStatus.OK
        );
    }

    @PutMapping(path = "/updateUser")
    public ResponseEntity<StandardResponse> updateUser(@RequestBody UserUpdateRequestDto userUpdateRequestDto){
        String message=userService.updateUser(userUpdateRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", message),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/searchUserByname/{userName}")
    public ResponseEntity<StandardResponse> searchUserByname(@PathVariable(value = "userName")String userName){
        UserByNameResponseDto userByNameResponseDto=userService.getUSerByUserName(userName);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", userByNameResponseDto),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/deleteUser/{userId}")
    public ResponseEntity<StandardResponse> deleterUserById(@PathVariable(value = "userId")int userId){
        String message=userService.deleteUserById(userId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", message),
                HttpStatus.OK
        );

    }

    //ading security
    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserSecurityService userSecurityService;

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userSecurityService.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);

        return new JwtResponse(token);
//        return new ResponseEntity<StandardResponse>(
//                new StandardResponse(200, "success", new JwtResponse(token)),
//                HttpStatus.OK
//        );
    }
}

