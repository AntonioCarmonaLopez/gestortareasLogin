package com.acl.gestorTareas.service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.acl.gestorTareas.domain.Usuario;
import com.acl.gestorTareas.repository.UsuarioRepository;

import java.util.Date;

@Service
public class AuthService {

    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Se lee del application.properties
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpirationMs;

    public AuthService(UsuarioRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Valida usuario y contraseña y genera JWT
     */
    public String login(String username, String password) {
        Usuario usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Compara password encriptada
        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return generateToken(usuario.getUsername());
    }

    /**
     * Genera JWT
     */
    @SuppressWarnings("deprecation")
	private String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}
