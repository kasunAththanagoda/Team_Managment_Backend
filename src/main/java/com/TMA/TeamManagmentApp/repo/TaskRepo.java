package com.TMA.TeamManagmentApp.repo;

import com.TMA.TeamManagmentApp.entity.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface TaskRepo extends JpaRepository<TasksEntity,Integer> {
    List<TasksEntity> findByAssignedToEquals(String userName);
}
