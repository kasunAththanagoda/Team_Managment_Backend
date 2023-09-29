package com.TMA.TeamManagmentApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TasksEntity {

    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    private ProjectEntity project;

    @Id
    @Column(name = "task_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;

    @Column(name = "title",length = 45)
    private String title;

    @Column(name = "content",length = 150)
    private String content;

    @Column(name = "assigned_to",length = 45)
    private String assignedTo;

    @Column(name = "created_by", length = 45)
    private String createdBy;

    @Column(name = "created_date", length = 45)
    private String createdDate;

    @Column(name = "due_date", length = 45)
    private String dueDate;

    @Column(name = "activestatus", columnDefinition = "TINYINT default 1")
    private boolean activeStatus;


    public TasksEntity(ProjectEntity project, String title, String content, String assignedTo, String createdBy, String createdDate, String dueDate, boolean activeStatus) {
        this.project = project;
        this.title = title;
        this.content = content;
        this.assignedTo = assignedTo;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.dueDate = dueDate;
        this.activeStatus = activeStatus;
    }
}
