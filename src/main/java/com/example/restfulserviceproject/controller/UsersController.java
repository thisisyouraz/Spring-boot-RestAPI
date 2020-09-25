package com.example.restfulserviceproject.controller;

import com.example.restfulserviceproject.model.User;
import com.example.restfulserviceproject.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    private UsersServiceImpl usersService;

    @GetMapping("/getUserById/id/{id}")
    public Optional<User> getUserById(@PathVariable int id){
       return usersService.getUserById(id);
    }

    @GetMapping("/getUserByPage/page/{page_no}")
    public Page<User> getUserByPage(@PathVariable int page_no){
        return usersService.getUserByPage(page_no);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return usersService.getAllUsers();
    }

    @PostMapping ("/postUser")
    public int postUser(@Valid @RequestBody User user){
        return usersService.addUser(user);
    }

    @DeleteMapping ("/deleteUserById/id/{id}")
    public void deleteUser(@PathVariable int id){
       usersService.deleteUser(id);
    }

    @PutMapping("/updateUser/id/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User newUser){
        usersService.updateUser(id,newUser);
    }
}
