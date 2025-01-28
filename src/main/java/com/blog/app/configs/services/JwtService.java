package com.blog.app.configs.services;

import com.blog.app.Entity.Request;
import com.blog.app.Utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JWTUtils jwtUtil;

    public String createJwtToken(Request authenticationRequest) throws Exception {
//        String identifier = authenticationRequest.getIdentifier(); // Assume this field contains the identifier
//        String password = authenticationRequest.getPassword();
//        UserDetails userDetails;
//
//        if (isValidEmail(identifier)) {
//            // Lookup by email
//            userDetails = userDetailsService.loadUserByEmail(identifier);
//        } else if (isValidPhoneNumber(identifier)) {
//            // Lookup by phone number
//            userDetails = userDetailsService.loadUserByPhoneNumber(identifier);
//        } else {
//            // Lookup by user ID
//            userDetails = userDetailsService.loadUserByUsername(identifier);
//        }
//        // Authenticate user
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(userDetails.getUsername(), password)
//        );
//
//        return jwtUtil.generateToken(userDetails);


                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                (authenticationRequest.getUsername()), authenticationRequest.getPassword()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        return jwtUtil.generateToken(userDetails);
    }

    private boolean isValidEmail(String input) {
        return input.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    private boolean isValidPhoneNumber(String input) {
        return input.matches("^\\d{10}$"); // Adjust regex based on your phone number format
    }
}