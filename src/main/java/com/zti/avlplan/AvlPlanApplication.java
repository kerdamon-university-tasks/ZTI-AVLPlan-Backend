package com.zti.avlplan;

import com.zti.avlplan.Authorisation.Domain.AppUser;
import com.zti.avlplan.Authorisation.Domain.Role;
import com.zti.avlplan.Authorisation.Services.UserService;
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
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CommandLineRunner run(UserService userService){
//        return args -> {
//            userService.saveRole(new Role("ROLE_USER"));
//            userService.saveRole(new Role("ROLE_ADMIN"));
//
//            userService.saveUser(new AppUser("John Doe", "doe", "123", new ArrayList<>()));
//
//            userService.addRoleToUser("doe", "ROLE_USER");
//        };
//    }

}
