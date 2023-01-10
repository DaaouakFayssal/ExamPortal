package com.examun.controller;


import com.examun.Impl.UserDetailsServiceImpl;
import com.examun.configuration.JwtUtils;
import com.examun.models.JwtRequest;
import com.examun.models.JwtResponce;
import com.examun.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@CrossOrigin("*")
@RestController

public class AuthenticateController {

    private AuthenticationManager authenticationManager;

    private UserDetailsServiceImpl userDetailsServiceImpl;

    private JwtUtils jwtUtils;



    public AuthenticateController(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsServiceImpl, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.jwtUtils = jwtUtils;
    }


    //generate Token

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST,headers = "Content-Type= multipart/form-data ,application/json")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest ) throws Exception {
        try {
       authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw  new Exception("User not found ");
        }

        //Authenticate
        UserDetails userDetails= this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
        String token =this.jwtUtils.generateToken(userDetails);
        return  ResponseEntity.ok(new JwtResponce(token));
    }


    private  void authenticate(String username , String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username ,password));

        }catch (DisabledException ex) {
            throw new Exception("User Disabel");
        }catch (BadCredentialsException e){
        throw  new Exception( "Invalid Credentional"+e.getMessage());
        }
    }

    //returning the details of user current
@GetMapping("/user-current")
    public User getUserCurrent(Principal principal){
        return  (User) this.userDetailsServiceImpl.loadUserByUsername(principal.getName());
    }
}
