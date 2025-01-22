package com.blog.app.APIs;

import com.blog.app.Configs.SecurityConfig.Utils.JwtService;
import com.blog.app.Entity.Request;
import com.blog.app.Entity.Users;
import com.blog.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("api/auth")
@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Request authenticationRequest) throws Exception {
        final String jwt = jwtService.createJwtToken(authenticationRequest);
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        if (userService.findByUsername(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken.");
        }
        userService.save(user);
        return ResponseEntity.ok("User registered successfully.");
    }

    @GetMapping("/getAllUsers")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
}
