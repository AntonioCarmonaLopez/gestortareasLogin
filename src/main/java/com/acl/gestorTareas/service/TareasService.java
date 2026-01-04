package com.acl.gestorTareas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acl.gestorTareas.domain.Tarea;
import com.acl.gestorTareas.repository.TareasRepository;

@Service
public class TareasService {
	@Autowired
    private TareasRepository repo;


    public List<Tarea> buscarTodas() {
        return repo.findAll();
    }

    public Tarea guardar(Tarea tarea) {
        return repo.save(tarea);
    }

    public void borrar(Long id) {
        repo.deleteById(id);
    }

}
