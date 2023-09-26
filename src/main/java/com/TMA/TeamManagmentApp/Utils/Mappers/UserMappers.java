package com.TMA.TeamManagmentApp.Utils.Mappers;

import com.TMA.TeamManagmentApp.Dto.Request.UserAddRequestDto;
import com.TMA.TeamManagmentApp.Entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMappers {
    UserEntity dtoToEntity(UserAddRequestDto userAddRequestDto);
}
