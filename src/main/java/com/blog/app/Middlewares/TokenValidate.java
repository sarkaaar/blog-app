package com.blog.app.Middlewares;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenValidate {

    @Value("${jwt.secret}")
    private String secret = "secretString";

    public boolean validateToken(String token) {
        String reCreatedToken = decodeToken(token);
        return verifyToken(token, reCreatedToken);
    }

    public String decodeToken(String token) {
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String[] chunks = token.split("\\.");
        String payload = new String(decoder.decode(chunks[1]));

        JSONObject obj = new JSONObject(payload);

        String email = obj.getString("email");
        long iat = obj.getLong("iat");
        long exp = obj.getLong("exp");

        if (isExpired(exp)) {
            return null;
        }

        return recreateToken(email, iat, exp);
    }

    public String recreateToken(String email, long iat, long exp) {

        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("email", email);
        claims.put("iat", iat);
        claims.put("exp", exp);

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public boolean verifyToken(String token, String reCreatedToken) {

        String[] reqToken = token.split("\\.");
        String[] createdToken = reCreatedToken.split("\\.");

        return (reqToken[2].equals(createdToken[2]));
    }

    public boolean isExpired(long exp) {
        return (System.currentTimeMillis() > exp);
    }
}
