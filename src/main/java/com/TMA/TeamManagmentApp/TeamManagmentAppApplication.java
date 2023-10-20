package com.TMA.TeamManagmentApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class TeamManagmentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamManagmentAppApplication.class, args);
	}

//		@Bean
//	public PasswordEncoder passwordEncoder(){
//		return NoOpPasswordEncoder.getInstance();
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
