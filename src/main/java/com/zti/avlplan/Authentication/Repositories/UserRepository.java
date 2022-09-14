package com.zti.avlplan.Authentication.Repositories;

import com.zti.avlplan.Authentication.Domain.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<AppUser, String> {
    AppUser findByUsername(String username);

}
