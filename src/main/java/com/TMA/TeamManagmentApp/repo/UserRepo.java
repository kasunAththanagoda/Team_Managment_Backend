package com.TMA.TeamManagmentApp.repo;

import com.TMA.TeamManagmentApp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {


    Optional<UserEntity> findByUserNameEquals(String userName);
}
