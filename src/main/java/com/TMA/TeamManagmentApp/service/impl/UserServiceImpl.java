package com.TMA.TeamManagmentApp.service.impl;

import com.TMA.TeamManagmentApp.Dto.Request.UserAddRequestDto;
import com.TMA.TeamManagmentApp.Dto.Request.UserLoginRequestDto;
import com.TMA.TeamManagmentApp.Dto.Request.UserUpdateRequestDto;
import com.TMA.TeamManagmentApp.Dto.Response.Paginated.PaginatedUserGetResponseDto;
import com.TMA.TeamManagmentApp.Dto.Response.UserByNameResponseDto;
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
        return savedUser.getUsername()+ " saved with id "+savedUser.getUserId();
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
        Optional<UserEntity> userEntity=userRepo.findByUsernameEquals(userLoginRequestDto.getUsername());
        if(userEntity.isPresent()){
            if(userEntity.get().getPassword().equals(userLoginRequestDto.getPassword())){
                return userEntity.get().getAvatar();
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

    @Override
    public String updateUser(UserUpdateRequestDto userUpdateRequestDto) {
        Optional<UserEntity> byId = userRepo.findById(userUpdateRequestDto.getUserId());
        if(byId.isPresent()){
            UserEntity userEntity = byId.get();
            userEntity.setUserFirstName(userUpdateRequestDto.getUserFirstName());
            userEntity.setUserLastName(userUpdateRequestDto.getUserLastName());
            userEntity.setNic(userUpdateRequestDto.getNic());
            userEntity.setUserJobTitle(userUpdateRequestDto.getUserJobTitle());
            userEntity.setActiveStatus(userUpdateRequestDto.isActiveStatus());
            userEntity.setUserEmail(userUpdateRequestDto.getUserEmail());
            userEntity.setUsername(userUpdateRequestDto.getUsername());
            userEntity.setPassword(userUpdateRequestDto.getPassword());
            userEntity.setAvatar(userUpdateRequestDto.getAvatar());

            userRepo.save(userEntity);
            return "user updated";
        }else{
            throw new NotFoundException("id not found");
        }
        }

    @Override
    public UserByNameResponseDto getUSerByUserName(String userName) {
        Optional<UserEntity> byUserNameEquals = userRepo.findByUsernameEquals(userName);
        if(byUserNameEquals.isPresent()){
            UserByNameResponseDto userByNameResponseDto =userMappers.entityToDto(byUserNameEquals.get());
            return userByNameResponseDto;
        }else{
            throw new NotFoundException("user not found");
        }
    }

    @Override
    public String deleteUserById(int userId) {
        if(userRepo.existsById(userId)){
            userRepo.deleteById(userId);
            return "deleted";
        }
        else{
            throw new NotFoundException("id not found");
        }
    }


}
