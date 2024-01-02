package com.blog.repository;

import com.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {



    Optional<User> findByEmail(String email);// private String email; should match with the variable

    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);  // used in checking whether the
                                                // newly entered username by the user already exists in  the db or not
    Boolean existsByEmail(String email);   // used in checking whether the
                                            // newly entered email by the user already exists in  the db or not


}
