package com.zti.avlplan.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

    public void registerNewUser(User user){
        authenticationRepository.save(user);
    }
}
