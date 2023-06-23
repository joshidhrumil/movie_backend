package com.demo.movie.service;

import com.demo.movie.Model.Shows;
import com.demo.movie.Model.UserResponse;
import com.demo.movie.Model.Users;
import com.demo.movie.Repository.UserRepository;
import com.demo.movie.SecurityService.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    AuthenticationManager authenticationManager;



    @Autowired
    private JwtUtils jwtUtils;

    public Users findByUsername(String email)
    {
        List<Users> user;
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        user = mongoTemplate.find(query,Users.class);
        if(user==null)
        {
            System.out.println("UserEmail Not Found");
            return null;
        }
        else{
            for(int i=0; i<user.size(); i++)
            {
                Users users= user.get(i);
                return users;
            }
        }
        return null;

    }

    @Override
    public UserResponse createUser(Users user) {
        Users ExistedUser = findByUsername(user.getEmail());
        if(ExistedUser==null)
        {
            try {
                Boolean value= true;
                user.setSoftDelete(value);
                Users CreatedUser=userRepository.save(user);
                return new UserResponse("Registered:-  "+CreatedUser.getName());
            }
            catch (Exception e)
            {
                return new UserResponse("Registration failed:-  "+user.getName());
            }
        }
        else if(ExistedUser.getEmail().equals(user.getEmail()))
        {
            return new UserResponse("Registration failed UserName Already Exists:- "+user.getEmail());
        }
        else{
            Boolean value= true;
            user.setSoftDelete(value);
            Users CreatedUser=userRepository.save(user);
            return new UserResponse("Registered:-  "+CreatedUser.getName());
        }
    }

    @Override
    public UserResponse authenticateUser(Users user) {
        String username= user.getEmail();
        String password= user.getPassword();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

        }
        catch (Exception e)
        {
            return new UserResponse("Bad credentials try again!!!:-  "+user.getName());
        }

        UserDetails loadedUser =loadUserByUsername(username);
        String GeneratedToken =jwtUtils.generateToken(loadedUser);

        return new UserResponse("Token:-  "+GeneratedToken);
    }

//    @Override
//    public UserResponse updateUser(Users user, String id) {
//        Users UpdatedUser=userRepository.save(user);
//        return new UserResponse(""+UpdatedUser.getName());
//    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> UserList;
        List<Users> ReturnUser = new ArrayList<>();
        UserList= userRepository.findAll();
        for(int i=0; i<UserList.size(); i++)
        {
            if(UserList.get(i).isSoftDelete()==true)
            {
                ReturnUser.add(UserList.get(i));
            }
        }
        return ReturnUser;
    }

    @Override
    public UserResponse deleteUserById(String id) {
        List<Users> user;
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        user = mongoTemplate.find(query,Users.class);
        for (int i=0 ; i<1 ; i++)
        {
            boolean value = user.get(i).isSoftDelete();
            System.out.println("Value:" +value);
            if(value==true)
            {
                value= false;
                user.get(i).setSoftDelete(value);
                System.out.println("Edited Value:"+user.get(i).isSoftDelete());
               Users deletedUSer = userRepository.save(user.get(i));
                return new UserResponse("User Deleted Succesfully"+deletedUSer.getName());
            }
        }
        return null;
    }

    @Override
    public String deleteAllUsers() {
        userRepository.deleteAll();
        return "All User Deleted";
    }

    @Override
    public List<Users> getAllUserRecord()
    {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user= findByUsername(email);
        if(user==null)
        {
            return null;
        }
        String userEmail=user.getEmail();
        String pwd=user.getPassword();
        return new User(userEmail , pwd, new ArrayList<>());
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }

//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        List<Users> user;
//        Query query = new Query();
//        query.addCriteria(Criteria.where("name").is(name));
//        user = mongoTemplate.find(query,Users.class);
//        return User(email,password,new ArrayList<>());
//    }
}
