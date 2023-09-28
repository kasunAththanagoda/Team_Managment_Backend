package com.TMA.TeamManagmentApp.service.impl;

import com.TMA.TeamManagmentApp.Dto.Request.UserAddRequestDto;
import com.TMA.TeamManagmentApp.Dto.Request.UserLoginRequestDto;
import com.TMA.TeamManagmentApp.Dto.Response.Paginated.PaginatedUserGetResponseDto;
import com.TMA.TeamManagmentApp.Dto.Response.UserGetResponseDto;
import com.TMA.TeamManagmentApp.entity.UserEntity;
import com.TMA.TeamManagmentApp.exception.NotFoundException;
import com.TMA.TeamManagmentApp.repo.UserRepo;
import com.TMA.TeamManagmentApp.service.UserService;
import com.TMA.TeamManagmentApp.utils.mappers.UserMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public String loginUser(UserLoginRequestDto userLoginRequestDto) {
        Optional<UserEntity> userEntity=userRepo.findByUserNameEquals(userLoginRequestDto.getUserName());
        if(userEntity.isPresent()){
            if(userEntity.get().getPassword().equals(userLoginRequestDto.getPassword())){
                return "user found";
            }
            else{
                throw new NotFoundException("password error");
            }
        }
        else {
            throw new NotFoundException("user name not found");
        }
    }

    @Override
    public List<UserGetResponseDto> getUsersWithoutPagination() {
        List<UserEntity> userEntities=userRepo.findAll();
        List<UserGetResponseDto> userGetResponseDtos=userMappers.entityListToDtoList(userEntities);
        return userGetResponseDtos;
    }


}
