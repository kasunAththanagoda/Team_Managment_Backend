package com.TMA.TeamManagmentApp.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserLoginRequestDto {

        private String username;
        private String password;
}
