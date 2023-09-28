package com.TMA.TeamManagmentApp.repo;

import com.TMA.TeamManagmentApp.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ProjectRepo extends JpaRepository<ProjectEntity,Integer> {
}
