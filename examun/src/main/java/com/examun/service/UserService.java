package com.examun.service;

import com.examun.models.Role;
import com.examun.models.User;
import com.examun.models.UserRole;

import java.util.Set;

public interface UserService {

    //creating user
    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User getUser( String username);

    void  deleteUser(Long userId);

}
