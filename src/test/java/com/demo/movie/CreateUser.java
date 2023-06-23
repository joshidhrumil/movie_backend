package com.demo.movie;

import com.demo.movie.Model.UserResponse;
import com.demo.movie.Model.Users;
import com.demo.movie.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@SpringBootTest
public class CreateUser {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Test
    public UserResponse createUser(@RequestBody Users user)
    {
        log.info("User Created:");
        return userServiceImpl.createUser(user);
    }

    @Test
    public List<Users> getAllUsers()
    {
        List<Users> users = userServiceImpl.getAllUsers();
        return users;
    }
}
