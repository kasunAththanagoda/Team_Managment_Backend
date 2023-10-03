package com.TMA.TeamManagmentApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "user_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "user_f_name",length = 45,nullable = false)
    private String userFirstName;

    @Column(name = "user_l_name",length = 45)
    private String userLastName ;

    @Column(name = "nic", length = 12, unique = true)
    private String nic;

    @Column(name = "user_job_title",length = 45)
    private String userJobTitle;

    @Column(name = "activestatus", columnDefinition = "TINYINT default 1")
    private boolean activeStatus;

    @Column(name = "user_email",length = 45)
    private String userEmail;

    @Column(name = "user_name",length = 45,unique = true)
    private String userName;

    @Column(name = "user_Password",length = 45)
    private String password;

    @Column(name = "avatar",length = 45)
    private String avatar;

}
