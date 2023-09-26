package com.TMA.TeamManagmentApp.Dto.Response.Paginated;

import com.TMA.TeamManagmentApp.Dto.Response.UserGetResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedUserGetResponseDto {
    private List<UserGetResponseDto> userGetResponseDtos;
    private long dataCount;

}
