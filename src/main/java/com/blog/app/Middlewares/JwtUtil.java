package com.blog.app.Middlewares;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {


    public static final long JWT_TOKEN_VALIDITY = 3600;  // Seconds
    @Value("${jwt.secret}")
    private String secret = "secretString";

    public JwtUtil() {
    }

    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<String, Object>();

        long iat =  System.currentTimeMillis();
        long exp = System.currentTimeMillis()+ (JWT_TOKEN_VALIDITY * 1000);

        claims.put("email", email);
        claims.put("iat", iat);
        claims.put("exp", exp);

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512,secret).compact();
    }


}