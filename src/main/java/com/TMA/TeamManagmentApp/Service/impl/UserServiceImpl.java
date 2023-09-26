package com.TMA.TeamManagmentApp.Service.impl;

import com.TMA.TeamManagmentApp.Dto.Request.UserAddRequestDto;
import com.TMA.TeamManagmentApp.Entity.UserEntity;
import com.TMA.TeamManagmentApp.Repo.UserRepo;
import com.TMA.TeamManagmentApp.Service.UserService;
import com.TMA.TeamManagmentApp.Utils.Mappers.UserMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
