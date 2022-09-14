package com.zti.avlplan.Authorisation.Repositories;

import com.zti.avlplan.Authorisation.Domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(String name);
}
