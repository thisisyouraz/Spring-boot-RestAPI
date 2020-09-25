package com.example.restfulserviceproject.others;

import com.example.restfulserviceproject.exception.UserNotFoundException;
import com.example.restfulserviceproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserService service;
    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/all-user")
    public List<User> getAllUser(){

        return service.getUserList();
    }

    @GetMapping("/getURI")
    public URI getRequestUri(){

        return ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
    }



    @GetMapping("/user/id/{id}")
    public User getParticularUser(@PathVariable  int id){
        User user=service.getParticularUser(id);

        if(user==null){
            throw new UserNotFoundException(" "+id);
        }

        return user;

    }

    @PostMapping("/all-user")
    public ResponseEntity addUser(@Valid @RequestBody User user){
         User newUser=service.addUser(user);

        URI location=ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").
                buildAndExpand(newUser.getId()).
                toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/user/id/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteUserByID(id);
    }

    @PutMapping("/user/id/{id}")
    public void updateUser(@RequestBody User user, @PathVariable int id){
        service.updateUser(id,user);
    }


   //-------------------------------------------//*

    @PostMapping("/addUser")
    public int adduser(@RequestBody User user){
        int user_id=userDaoService.addUser(user);
        return user_id;
    }

    @GetMapping("/getUser/id/{id}")
    public User getUser(@PathVariable int id){

        User user=userDaoService.getUser(id);

        if(user==null){
            throw new UserNotFoundException(" "+id);
        }

       return user;
    }


    @PutMapping("/update/id/{id}/{newName}")
    public User updateUser(@PathVariable int id, @PathVariable String newName ){
        User updatedUser=userDaoService.updateUser(id,newName);
        return updatedUser;
    }


    @DeleteMapping ("/delete/id/{id}")
    public void deleteUserById(@PathVariable int id){
     userDaoService.delete(id);
    }
}
