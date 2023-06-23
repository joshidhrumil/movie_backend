package com.demo.movie.Controller;

import com.demo.movie.Model.UserResponse;
import com.demo.movie.Model.Users;
import com.demo.movie.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController{

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping(value = "/createUser")
    public UserResponse createUsers(@RequestBody Users user) {
        return userServiceImpl.createUser(user);
    }

    @PostMapping(value = "/authenticateUser")
    public UserResponse authenticateUsers(@RequestBody Users user) {

        return userServiceImpl.authenticateUser(user);
    }
//
//    @PostMapping(value = "/updateUser")
//    public UserResponse updateUsers(@RequestBody Users user,@PathVariable String id)
//    {
//        return userServiceImpl.createUser(user,id);
//    }

    @GetMapping(value = "/getAllUsers")
    public List<Users> getAllUser() {
        return userServiceImpl.getAllUsers();
    }


    @GetMapping(value = "/getAllUserRecords")
    public List<Users> getAllShowsRecords()
    {
        return userServiceImpl.getAllUserRecord();
    }

    @GetMapping(value = "/deleteUserById/{id}")
    public UserResponse deleteUsersById(@PathVariable String id)
    {
        return userServiceImpl.deleteUserById(id);
    }

    @DeleteMapping(value = "/deleteUsers")
    public String deleteAllUser()
    {
        return userServiceImpl.deleteAllUsers();
    }

}
