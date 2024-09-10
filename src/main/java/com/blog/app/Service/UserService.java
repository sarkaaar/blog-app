package com.blog.app.Service;

import com.blog.app.Entity.User;
import com.blog.app.Middlewares.*;
import com.blog.app.Reposotory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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

    public User getUserByID(String userID, String jwtToken) {

        if (!validateUserToken(userID, jwtToken)) {
            return null;
        }

        return userRepository.findByUserID(userID);
    }

    public String updateUser(String userID, User newUser, String jwtToken, String csrfToken) {
        if (!csrf.getToken(csrfToken)) {
            return null;
        }
        if (!validateUserToken(userID, jwtToken)) {
            return null;
        }

        Optional<User> user = userRepository.findById(newUser.getId());

        String encryptedPass = encrypt.encrypt(newUser.getPassword(), "secret");

        user.ifPresent(user1 -> {
            user1.setName(newUser.getName());
            user1.setEmail(newUser.getEmail());
            user1.setPassword(encryptedPass);
        });

        userRepository.save(user.get());
        return csrf.generateToken();
    }

    public Boolean loginUser(String email, String password) {
        String encryptedPass = encrypt.encrypt(password, "secret");

        User user = userRepository.findByEmailAndPassword(email, encryptedPass);

        if (user != null) {
            return true;
        }

        return false;
    }

    private boolean validateUserToken(String userID, String jwtToken) {
        String tokenEmail = emailValidate.getUserEmail(jwtToken);
        User derivedUser = userRepository.findByEmail(tokenEmail);

        return (derivedUser.getEmail().equals(userID) && validateToken.validateToken(jwtToken));

    }
}
