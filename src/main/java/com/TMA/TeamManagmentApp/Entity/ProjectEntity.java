package com.TMA.TeamManagmentApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectEntity {

    @Id
    @Column(name = "project_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;

    @Column(name = "project_name",length = 45)
    private String projectName;

    @Column(name = "starting_date",length = 45)
    private String startingDate ;

    @Column(name = "due_date",length = 45)
    private String dueDate ;

    @Column(name = "creadted_by", length = 45)
    private String createdBy;

    @Column(name = "team_members", length = 150)
    private String teamMembers;

    @Column(name = "activestatus", columnDefinition = "TINYINT default 1")
    private boolean activeStatus;
}
