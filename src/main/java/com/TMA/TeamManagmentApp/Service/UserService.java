package com.TMA.TeamManagmentApp.Service;

import com.TMA.TeamManagmentApp.Dto.Request.UserAddRequestDto;
import com.TMA.TeamManagmentApp.Dto.Response.Paginated.PaginatedUserGetResponseDto;
import com.TMA.TeamManagmentApp.Dto.Response.UserGetResponseDto;

import java.util.List;

public interface UserService {
    String addUSer(UserAddRequestDto userAddRequestDto);

    PaginatedUserGetResponseDto getUsers(int page, int size);
}
