package com.acl.gestorTareas.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.acl.gestorTareas.domain.Tarea;


public interface TareasRepository extends JpaRepository<Tarea, Long> {
}



