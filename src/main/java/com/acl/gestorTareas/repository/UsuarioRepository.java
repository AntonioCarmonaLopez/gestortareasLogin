package com.acl.gestorTareas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acl.gestorTareas.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
