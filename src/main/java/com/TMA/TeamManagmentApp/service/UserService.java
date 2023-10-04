package com.TMA.TeamManagmentApp.service;

import com.TMA.TeamManagmentApp.Dto.Request.UserAddRequestDto;
import com.TMA.TeamManagmentApp.Dto.Request.UserLoginRequestDto;
import com.TMA.TeamManagmentApp.Dto.Request.UserUpdateRequestDto;
import com.TMA.TeamManagmentApp.Dto.Response.Paginated.PaginatedUserGetResponseDto;
import com.TMA.TeamManagmentApp.Dto.Response.UserByNameResponseDto;
import com.TMA.TeamManagmentApp.Dto.Response.UserGetResponseDto;

import java.util.List;

public interface UserService {
    String addUSer(UserAddRequestDto userAddRequestDto);

    PaginatedUserGetResponseDto getUsers(int page, int size);

    String loginUser(UserLoginRequestDto userLoginRequestDto);


    List<UserGetResponseDto> getUsersWithoutPagination();

    String updateUser(UserUpdateRequestDto userUpdateRequestDto);

    UserByNameResponseDto getUSerByUserName(String userName);

    String deleteUserById(int userId);
}
