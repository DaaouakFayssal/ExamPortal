package com.examun.Impl;


import com.examun.helper.UserFoundException;
import com.examun.models.User;
import com.examun.models.UserRole;
import com.examun.repo.RoleRepository;
import com.examun.repo.UserRepository;
import com.examun.service.UserService;


import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    //Creating Users
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws  Exception  {
        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("user already there ");
           throw new UserFoundException();

        } else {
            //creating user
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
