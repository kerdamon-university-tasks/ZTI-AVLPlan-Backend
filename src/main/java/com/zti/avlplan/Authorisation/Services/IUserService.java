package com.zti.avlplan.Authorisation.Services;

import com.zti.avlplan.Authorisation.Domain.AppUser;
import com.zti.avlplan.Authorisation.Domain.Role;

import java.util.List;

public interface IUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
