package com.demo.movie.service;

import com.demo.movie.Model.UserResponse;
import com.demo.movie.Model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public abstract class UserService implements UserDetailsService {
    public abstract UserResponse createUser(@RequestBody Users user);
    public abstract UserResponse authenticateUser(@RequestBody Users user);
//    public UserResponse updateUser(@RequestBody Users user , @PathVariable String id);
    public abstract List<Users> getAllUsers();
    public abstract UserResponse deleteUserById(@PathVariable String id);
    public abstract String deleteAllUsers();
    public abstract List<Users> getAllUserRecord();





}
