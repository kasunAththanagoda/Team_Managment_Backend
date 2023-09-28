package com.TMA.TeamManagmentApp.utils.mappers;

import com.TMA.TeamManagmentApp.Dto.Request.UserAddRequestDto;
import com.TMA.TeamManagmentApp.Dto.Response.UserGetResponseDto;
import com.TMA.TeamManagmentApp.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMappers {
    UserEntity dtoToEntity(UserAddRequestDto userAddRequestDto);

    List<UserGetResponseDto> pageToDtoList(Page<UserEntity> userEntities);


    List<UserGetResponseDto> entityListToDtoList(List<UserEntity> userEntities);
}
