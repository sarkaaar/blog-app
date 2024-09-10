package com.blog.app.APIs;

import com.blog.app.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

@CrossOrigin(origins = "*")
@RequestMapping("api/v1/auth")
@RestController
public class AuthController {
    private final UserService userService;
    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
//    @PostMapping
//    public Response loginUser(@RequestBody JwtRequest request) throws SQLException {
//        return userService.loginUser(request.getEmail(), request.getPassword());
//    }
}
