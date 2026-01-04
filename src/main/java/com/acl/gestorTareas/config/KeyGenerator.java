package com.acl.gestorTareas.config;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;

public class KeyGenerator {
    public static void main(String[] args) {
        String secret = Base64.getEncoder().encodeToString(
            Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded()
        );
        System.out.println("jwt.secret=" + secret);
    }
}
