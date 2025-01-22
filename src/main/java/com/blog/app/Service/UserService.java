package com.blog.app.Service;

import com.blog.app.Configs.SecurityConfig.Utils.JWTUtils;
import com.blog.app.Entity.Users;
import com.blog.app.Middlewares.EmailValidate;
import com.blog.app.Middlewares.PassEncrypt;
import com.blog.app.Middlewares.TokenValidate;
import com.blog.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    JWTUtils jwt;

    @Autowired
    TokenValidate validateToken;

    @Autowired
    EmailValidate emailValidate;

    @Autowired
    PassEncrypt encrypt;

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return (List<Users>) userRepository.findAll();
    }

    public Users save(Users user) {
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    public Users findByUsername(String username) {
        return userRepository.findByEmail(username);
    }
//
    public Boolean signUp(Users user) {
        String encryptedPass = encrypt.encrypt(user.getPassword(), "secret");
        user.setPassword(encryptedPass);
        Users existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            return false;
        }

        userRepository.save(user);

        return true;
    }

    public Boolean loginUser(String email, String password) {
        String encryptedPass = encrypt.encrypt(password, "secret");

        Users user = userRepository.findByEmailAndPassword(email, encryptedPass);

        return user != null;
    }



}
