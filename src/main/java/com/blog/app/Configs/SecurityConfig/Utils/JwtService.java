package com.blog.app.Configs.SecurityConfig.Utils;


//import org.example.gatewayauth.model.AuthenticationRequest;
//import org.example.gatewayauth.util.JwtUtil;
import com.blog.app.Configs.SecurityConfig.CustomUserDetailsService;
import com.blog.app.Entity.Request;
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
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getEmail(), authenticationRequest.getPassword()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        return jwtUtil.generateToken(userDetails);
    }
}