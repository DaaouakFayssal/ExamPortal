package com.examun.Impl;

import com.examun.models.User;
import com.examun.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@Component
public class UserDetailsServiceImpl implements UserDetailsService  {

   private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=this.userRepository.findByUsername(username);

        if (user==null){
            System.out.println("user Note Found");
            throw  new UsernameNotFoundException("User not Found");
        }
        return user;
    }
}
