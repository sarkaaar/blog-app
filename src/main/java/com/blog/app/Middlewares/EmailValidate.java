package com.blog.app.Middlewares;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class EmailValidate {


    public String getUserEmail(String token) {

        Base64.Decoder decoder = Base64.getUrlDecoder();
        String[] chunks = token.split("\\.");
        String payload = new String(decoder.decode(chunks[1]));

        JSONObject obj = new JSONObject(payload);

        return obj.getString("email");
    }

}
