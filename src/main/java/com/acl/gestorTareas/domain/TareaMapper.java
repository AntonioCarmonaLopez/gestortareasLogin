package com.acl.gestorTareas.domain;

import java.util.List;

import org.mapstruct.Mapper;


import com.acl.gestorTareas.dto.TareaDTO;

@Mapper(componentModel = "spring")
public interface TareaMapper {

	
    TareaDTO toDTO(Tarea tarea);

    Tarea toEntity(TareaDTO dto);
    
    List<TareaDTO> toListDTO(List<Tarea> tareas);
    
    List<Tarea> toListEntity(List<TareaDTO> dtos);
}
