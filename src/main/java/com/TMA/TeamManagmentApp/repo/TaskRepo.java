package com.TMA.TeamManagmentApp.repo;

import com.TMA.TeamManagmentApp.entity.TasksEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface TaskRepo extends JpaRepository<TasksEntity,Integer> {
    List<TasksEntity> findByAssignedToEqualsAndActiveStatusEquals(String userName,boolean activeStatus);

    @Query(value = "select activestatus from tasks where task_id=?1 ",nativeQuery = true)
    int getStatus(int taskId);

//    @Modifying
//    @Query(value = "update tasks set activestatus=?1 where task_id=?2",nativeQuery = true)
//    int setStatus(boolean taskStatus, int taskId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tasks SET activestatus = :newActiveStatus WHERE task_id = :taskId", nativeQuery = true)
    int updateActiveStatusByTaskIdNativeQuery(int taskId, boolean newActiveStatus);
}
