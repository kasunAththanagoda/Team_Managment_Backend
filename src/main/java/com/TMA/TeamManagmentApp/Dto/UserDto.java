package com.TMA.TeamManagmentApp.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int userId;
    private String userFirstName;
    private String userLastName;
    private String nic;
    private String userJobTitle;
    private boolean activeStatus;
    private String userEmail;
    private String username;
    private String password;
    private String avatar;
}
