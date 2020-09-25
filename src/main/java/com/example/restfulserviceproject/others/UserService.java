package com.example.restfulserviceproject.others;

import com.example.restfulserviceproject.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserService {

    public static List<User> userList=new ArrayList<>();
    static {
        userList.add(new User(1, "Ayaz", new Date()));
        userList.add(new User(2, "Hamza", new Date()));
        userList.add(new User(3, "Haris", new Date()));
    }

    public List<User> getUserList() {
        return userList;
    }

    public User getParticularUser(int id){
        for (User user:userList) {
            if(user.getId()==id){
                return user;
            }
        }
       // return new User(-1,"dummy",new Date());
    return  null;
    }

    public User addUser(User user){
        userList.add(user);
        return user;
    }

    public void deleteUserByID(int id){
        for (User user: userList) {
            if(user.getId()==id)
                userList.remove(user);
        }
    }
    public void updateUser(int id,User updatedUser){
        userList.set(id-1,updatedUser);
    }

}
