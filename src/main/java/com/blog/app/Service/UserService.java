package com.blog.app.Service;

import com.blog.app.Entity.Users;
import com.blog.app.Middlewares.PassEncrypt;
import com.blog.app.Repository.UserRepository;
import com.blog.app.Utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    JWTUtils jwt;

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

    public Boolean userSignUp(Users user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty() == true) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);

            userRepository.save(user);
            return true;
        } else
            return false;
    }


}
