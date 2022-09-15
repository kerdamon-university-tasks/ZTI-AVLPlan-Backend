package com.zti.avlplan.Interceptors;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;

import static java.util.Arrays.stream;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        String token = authorizationHeader.substring("Bearer ".length());
//        Algorithm algorithm = Algorithm.HMAC256("secret");
//        JWTVerifier verifier = JWT.require(algorithm).build();
//        DecodedJWT decodedJWT = verifier.verify(token);
//
//        String username = decodedJWT.getSubject();
//        String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
//        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        stream(roles).forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));

        if (request.getHeader("Authorization") == null){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
//        else if (request.getHeader("Authorization").equals("Test"))    {
//
//            log.info("Validation OK.");
//            return true;
//        } else {
//            log.info("Validation NOK.");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }

        return true;
    }

}