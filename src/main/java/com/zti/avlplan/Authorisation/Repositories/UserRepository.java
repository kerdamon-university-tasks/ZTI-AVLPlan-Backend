package com.zti.avlplan.Authorisation.Repositories;

import com.zti.avlplan.Authorisation.Domain.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<AppUser, String> {
    AppUser findByUsername(String username);

}
