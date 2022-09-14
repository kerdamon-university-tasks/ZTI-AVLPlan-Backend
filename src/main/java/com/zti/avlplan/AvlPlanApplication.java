package com.zti.avlplan;

import com.zti.avlplan.Authentication.Domain.AppUser;
import com.zti.avlplan.Authentication.Domain.Role;
import com.zti.avlplan.Authentication.Services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class AvlPlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvlPlanApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CommandLineRunner run(UserService userService){
//        return args -> {
////            userService.saveRole(new Role("ROLE_USER"));
////
////            userService.saveUser(new AppUser("John Doe", "doe", "123", new ArrayList<>()));
//
////            userService.addRoleToUser("doe", "ROLE_USER");
//        };
//    }

}
