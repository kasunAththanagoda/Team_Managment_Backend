package com.TMA.TeamManagmentApp.Service.impl;

import com.TMA.TeamManagmentApp.Dto.Request.UserAddRequestDto;
import com.TMA.TeamManagmentApp.Dto.Response.Paginated.PaginatedUserGetResponseDto;
import com.TMA.TeamManagmentApp.Dto.Response.UserGetResponseDto;
import com.TMA.TeamManagmentApp.Entity.UserEntity;
import com.TMA.TeamManagmentApp.Repo.UserRepo;
import com.TMA.TeamManagmentApp.Service.UserService;
import com.TMA.TeamManagmentApp.Utils.Mappers.UserMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMappers userMappers;

    @Override
    public String addUSer(UserAddRequestDto userAddRequestDto) {
        UserEntity userEntity = userMappers.dtoToEntity(userAddRequestDto);
        userEntity.setActiveStatus(true);
        UserEntity savedUser = userRepo.save(userEntity);
        return savedUser.getUserName()+ " saved with id "+savedUser.getUserId();
    }

    @Override
    public PaginatedUserGetResponseDto getUsers(int page, int size) {
        Page<UserEntity> userEntities=userRepo.findAll(PageRequest.of(page,size));
        PaginatedUserGetResponseDto paginatedUserGetResponseDto=new PaginatedUserGetResponseDto(
                userMappers.pageToDtoList(userEntities),
                userRepo.count()
        );
        return paginatedUserGetResponseDto;
    }


}
