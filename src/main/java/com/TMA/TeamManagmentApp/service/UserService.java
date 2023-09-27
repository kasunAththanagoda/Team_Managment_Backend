package com.TMA.TeamManagmentApp.service;

import com.TMA.TeamManagmentApp.Dto.Request.UserAddRequestDto;
import com.TMA.TeamManagmentApp.Dto.Request.UserLoginRequestDto;
import com.TMA.TeamManagmentApp.Dto.Response.Paginated.PaginatedUserGetResponseDto;

public interface UserService {
    String addUSer(UserAddRequestDto userAddRequestDto);

    PaginatedUserGetResponseDto getUsers(int page, int size);

    String loginUser(UserLoginRequestDto userLoginRequestDto);
}
