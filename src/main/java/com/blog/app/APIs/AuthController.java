package com.blog.app.APIs;

import com.blog.app.Entity.Request;
import com.blog.app.Entity.Users;
import com.blog.app.Service.UserService;
import com.blog.app.configs.services.JwtService;
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

    @PostMapping("/sign-in")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Request authRequest) throws Exception {
        final String jwt = jwtService.createJwtToken(authRequest);
        return ResponseEntity.ok(jwt);
    }


    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@RequestBody Users user) {
        if (userService.userSignUp(user))
            return ResponseEntity.ok("User registered successfully.");
        else
            return ResponseEntity.internalServerError().body("Some Error Occurred While Sign Up");
    }

    @GetMapping("/getAllUsers")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
}
