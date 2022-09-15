package com.zti.avlplan.AuthenticationOld.Services;

import com.zti.avlplan.AuthenticationOld.Domain.AppUser;
import com.zti.avlplan.AuthenticationOld.Domain.Role;

import java.util.List;

public interface IUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
