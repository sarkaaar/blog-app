package com.blog.app.APIs;

import com.blog.app.Entity.JwtRequest;
import com.blog.app.Entity.User;
import com.blog.app.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

@CrossOrigin(origins = "*")
@RequestMapping("api/auth")
@RestController
public class AuthController {
    @Autowired
    private final UserService userService;
    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("sign-in")
    public Boolean loginUser(@RequestBody JwtRequest request) throws SQLException {
        return userService.loginUser(request.getEmail(), request.getPassword());
    }

    @PostMapping("sign-up")
    public Boolean signUpUser(@RequestBody User user) throws SQLException {
        return userService.signUp(user);
    }
}
