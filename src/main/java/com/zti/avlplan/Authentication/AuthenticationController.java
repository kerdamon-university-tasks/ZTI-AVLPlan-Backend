package com.zti.avlplan.Authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
@Slf4j
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginData){
        return authenticationService.login(loginData.getUsername(), loginData.getPassword());
    }

    @PostMapping("/register")
    public void register(@RequestBody LoginDTO registerData){
        log.info("loginData {}", registerData.getUsername());
        var user = new User(registerData.getUsername(), registerData.getPassword());
        authenticationService.registerNewUser(user);
    }
}
