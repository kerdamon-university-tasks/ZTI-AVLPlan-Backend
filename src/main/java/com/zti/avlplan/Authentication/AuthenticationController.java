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
        log.info("loginData {}", loginData.getUsername());
        var user = authenticationService.getUserByUsername(loginData.getUsername());
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000))
                .sign(algorithm);
    }

    @PostMapping("/register")
    public void register(@RequestBody LoginDTO registerData){
        log.info("loginData {}", registerData.getUsername());
        var user = new User(registerData.getUsername(), registerData.getPassword());
        authenticationService.registerNewUser(user);
    }
}
