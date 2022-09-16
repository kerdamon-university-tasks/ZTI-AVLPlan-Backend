package com.zti.avlplan.Authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zti.avlplan.Authentication.Exceptions.AlreadyExistsException;
import com.zti.avlplan.Authentication.Exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
@Slf4j
public class AuthenticationService {
    final private AuthenticationRepository authenticationRepository;

    @Autowired
    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public User getUserByUsername(String username) {
        var user = authenticationRepository.findByUsername(username);
        if(user.isEmpty()){
            throw new UserNotFoundException();
        }
        return user.get();
    }

    public void registerNewUser(User newUser){
        var user = authenticationRepository.findByUsername(newUser.getUsername());
        if(user.isPresent()){
            throw new AlreadyExistsException();
        }
        authenticationRepository.save(newUser);
    }

    public String login(String username, String password){
        var user = getUserByUsername(username);
        if(!Objects.equals(password, user.getPassword())){
            log.error("Wrong password. Was {}, should be {}", password, user.getPassword());
            throw new RuntimeException("Wrong Password!");
        }
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000))
                .sign(algorithm);
    }

    public boolean isTokenValid(String token){
        try{
            token = token.substring("Bearer ".length());
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            String username = decodedJWT.getSubject();
        } catch (JWTVerificationException e) {
            log.error("Error: {}", e);
            return false;
        }
        return true;
    }

    public String getUserFromToken(String token){
        try{
            token = token.substring("Bearer ".length());
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT.getSubject();
        } catch (JWTVerificationException e) {
            log.error("Error: {}", e);
        }
        return "";
    }
}
