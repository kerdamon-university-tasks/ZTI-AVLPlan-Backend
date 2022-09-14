package com.zti.avlplan.Authentication.Repositories;

import com.zti.avlplan.Authentication.Domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(String name);
}
