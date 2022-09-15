package com.zti.avlplan.AuthenticationOld.Repositories;

import com.zti.avlplan.AuthenticationOld.Domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(String name);
}
