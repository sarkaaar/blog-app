package com.blog.app.Service;

import com.blog.app.Entity.User;
import com.blog.app.Middlewares.*;
import com.blog.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {
    JwtUtil jwt = new JwtUtil();
    CsrfUtil csrf = new CsrfUtil();

    TokenValidate validateToken = new TokenValidate();
    EmailValidate emailValidate = new EmailValidate();
    PassEncrypt encrypt = new PassEncrypt();

    @Autowired
    private UserRepository userRepository;

    public Boolean signUp(User user) {
        String encryptedPass = encrypt.encrypt(user.getPassword(), "secret");
        user.setPassword(encryptedPass);
        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            return false;
        }

        userRepository.save(user);

        return true;
    }

    public Boolean loginUser(String email, String password) {
        String encryptedPass = encrypt.encrypt(password, "secret");

        User user = userRepository.findByEmailAndPassword(email, encryptedPass);

        if (user != null) {
            return true;
        }

        return false;
    }

}
