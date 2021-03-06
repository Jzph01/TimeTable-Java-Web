package com.enjoyyourtime.app.repositories;

import com.enjoyyourtime.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findOneByUsername(String username);

    @Query(value = "SELECT u FROM User AS u")
    List<User> findAll();
}
