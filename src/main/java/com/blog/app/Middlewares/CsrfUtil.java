package com.blog.app.Middlewares;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class CsrfUtil {
    static final String randomTokenString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789?,-)(*&";
    static SecureRandom rnd = new SecureRandom();
    private static final List<String> tokenList = new ArrayList<String>();

    String randomString() {
        StringBuilder sb = new StringBuilder(128);
        for (int i = 0; i < 128; i++)
            sb.append(randomTokenString.charAt(rnd.nextInt(randomTokenString.length())));
        return sb.toString();
    }

    public String generateToken() {
        String randomStr = randomString();
        insertToken(randomStr);
        return randomStr;
    }

    public void insertToken(String token) {
        tokenList.add("Bearer " + token);
    }

    public boolean getToken(String token) {
        boolean csrf = tokenList.contains(token);
        deleteToken(token);
        return csrf;
    }

    public void deleteToken(String token) {
        tokenList.remove(token);
    }
}
