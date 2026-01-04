package com.acl.gestorTareas.controller;

import com.acl.gestorTareas.domain.Tarea;
import com.acl.gestorTareas.domain.TareaMapper;
import com.acl.gestorTareas.dto.TareaDTO;
import com.acl.gestorTareas.service.TareasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/tareas")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
@Tag(name = "Tareas", description = "API para gestionar tareas")
public class TareaController {

	@Autowired
	private TareaMapper mapper;
	
	private final TareasService service;

	public TareaController(TareasService service) {
		this.service = service;
	}
	@Operation(
	        summary = "Obtener todas las tareas",
	        description = "Devuelve una lista con todas las tareas registradas"
	    )
	    @ApiResponses({
	        @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente"),
	        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
	    })
	@GetMapping(value = "/gettareas")
	
	public List<TareaDTO> getTodas() {
		return mapper.toListDTO(service.buscarTodas());
	}

	@DeleteMapping("/borrar/{id}")
	public void borrar(@PathVariable Long id) {
		service.borrar(id);
	}

	@PostMapping(value = "/guardartarea")
	public TareaDTO guardar(@RequestBody Tarea tarea) {
		Tarea tareaGuardada = service.guardar(tarea);
		return mapper.toDTO(tareaGuardada);
	}
}
