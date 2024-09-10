package com.blog.app.Reposotory;


import com.blog.app.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserID(String userID);

    User findByEmail(String email);

    public User findByEmailAndPassword(String email, String password);
}
