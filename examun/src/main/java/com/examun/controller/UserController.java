package com.examun.controller;


import com.examun.models.Role;
import com.examun.models.User;
import com.examun.models.UserRole;
import com.examun.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
   private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(value = "/add", headers="Accept=application/json",
            method = RequestMethod.POST)

    public User createUser(@RequestBody User user) throws  Exception  {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setProfile("default.png");
        Set<UserRole>roles= new HashSet<>();
        Role role =new Role();
        role.getRoleId(44L);
        role.setRoleName("NORMAL");
        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        return  this.userService.createUser(user,roles);
    }
    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public  User getUser(@PathVariable("username") String  username){
        return userService.getUser(username);
    }
  // delete user by id

    @RequestMapping(value = "/delete/{userId}")

    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }

    //Update une User

    }


