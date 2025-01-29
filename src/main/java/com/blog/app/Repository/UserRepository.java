package com.blog.app.Repository;


import com.blog.app.Entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

    Users findByEmail(String email);
    Optional<Users> findByUsername(String username);
    Users findByPhone(String email);

    Users findByEmailAndPassword(String email, String password);
}
