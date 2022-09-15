package com.zti.avlplan.Authentication;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
