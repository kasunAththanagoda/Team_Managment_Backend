package com.TMA.TeamManagmentApp.service;

import com.TMA.TeamManagmentApp.details.CustomerUserDetails;
import com.TMA.TeamManagmentApp.entity.UserEntity;
import com.TMA.TeamManagmentApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user=userRepo.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User not Found");
        }
        return new CustomerUserDetails(user);
    }
}
