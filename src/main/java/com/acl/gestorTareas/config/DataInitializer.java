package com.acl.gestorTareas.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.acl.gestorTareas.domain.Usuario;
import com.acl.gestorTareas.repository.UsuarioRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {

            if (usuarioRepository.findByUsername("admin").isEmpty()) {
                Usuario admin = new Usuario();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRol("ADMIN");

                usuarioRepository.save(admin);
                System.out.println("Usuario admin creado");
            }

            if (usuarioRepository.findByUsername("user").isEmpty()) {
                Usuario user = new Usuario();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("user123"));
                user.setRol("USER");

                usuarioRepository.save(user);
                System.out.println("Usuario user creado");
            }
        };
    }
}
