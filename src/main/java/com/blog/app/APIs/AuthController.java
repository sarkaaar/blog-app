package com.blog.app.APIs;

import com.blog.app.Entity.JwtRequest;
import com.blog.app.Entity.User;
import com.blog.app.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("api/auth")
@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/sign-in")
    public User loginUser(@RequestBody JwtRequest request) {
//        return userService.loginUser(request.getEmail(), request.getPassword());
    return new User();
    }

    @PostMapping("/sign-up")
    public User signUpUser(@RequestBody User user) {
//        return userService.signUp(user);
        return new User();
    }
}
