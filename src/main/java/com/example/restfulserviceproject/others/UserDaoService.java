package com.example.restfulserviceproject.others;

import com.example.restfulserviceproject.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Repository // represent something which interact with the database.
@Transactional // this says each method is involve in a transaction.
public class UserDaoService {


    @PersistenceContext
    private EntityManager entityManager;

    public int addUser(User user){
        entityManager.persist(user);
        return user.getId();
    }

    public User getUser(int id){

       return entityManager.find(User.class,id);
    }

    public User updateUser(int id, String newName){
        User user=entityManager.find(User.class,id);
        user.setName(newName);
        return user;
    }

    public void delete(int id){
       entityManager.remove( entityManager.find(User.class,id));
    }

}
