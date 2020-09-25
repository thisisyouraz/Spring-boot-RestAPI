package com.example.restfulserviceproject.service;

import com.example.restfulserviceproject.exception.UserNotFoundException;
import com.example.restfulserviceproject.model.User;
import com.example.restfulserviceproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();

    }

    @Override
    public Page<User> getUserByPage(int page_no) {
        Page<User> userByPage = userRepository.findAll(PageRequest.of(page_no, 1));
        if (userByPage.isEmpty()) {
            throw new UserNotFoundException("page Not found");
        }

        return userByPage;
    }

    @Override
    public int addUser(User user) {
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public void deleteUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(int id, User newUser) {
        Optional<User> user = userRepository.findById(id);
        user.get().setName(newUser.getName());
        user.get().setB_date(newUser.getB_date());
        userRepository.save(user.get());
    }
}
