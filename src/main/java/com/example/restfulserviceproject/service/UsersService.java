package com.example.restfulserviceproject.service;

import com.example.restfulserviceproject.model.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    public Optional<User> getUserById(int id);

    public List<User> getAllUsers();
    public Page<User> getUserByPage(int page_no);
    public int addUser(User user);
    public void deleteUser(int id);
    public void updateUser(int id, User newUser);

}
