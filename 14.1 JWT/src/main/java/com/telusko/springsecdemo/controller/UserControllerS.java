package com.telusko.springsecdemo.controller;

import com.telusko.springsecdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserControllerS {


    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("login")
    public Object login(@RequestBody User user) {
     try {

         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

         SecurityContextHolder.getContext().setAuthentication();
         return null;
     }catch (BadCredentialsException e){
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
     }

    }
}

