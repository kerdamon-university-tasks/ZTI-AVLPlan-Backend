package com.zti.avlplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvlPlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvlPlanApplication.class, args);
    }

//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

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
