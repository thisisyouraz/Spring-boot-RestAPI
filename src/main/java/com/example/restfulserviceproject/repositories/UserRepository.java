package com.example.restfulserviceproject.repositories;

import com.example.restfulserviceproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // class which talks to the database.

//JPA repository gives us some functionality.
public interface UserRepository extends JpaRepository<User,Integer> {

    // we can define our specific queries here.

}
