package com.acl.gestorTareas.domain;

import com.acl.gestorTareas.dto.TareaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-04T16:47:27+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.9 (Ubuntu)"
)
@Component
public class TareaMapperImpl implements TareaMapper {

    @Override
    public TareaDTO toDTO(Tarea tarea) {
        if ( tarea == null ) {
            return null;
        }

        TareaDTO tareaDTO = new TareaDTO();

        tareaDTO.setId( tarea.getId() );
        tareaDTO.setTitulo( tarea.getTitulo() );
        tareaDTO.setDescripcion( tarea.getDescripcion() );
        tareaDTO.setFechaCreacion( tarea.getFechaCreacion() );
        tareaDTO.setEstado( tarea.getEstado() );

        return tareaDTO;
    }

    @Override
    public Tarea toEntity(TareaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tarea tarea = new Tarea();

        tarea.setId( dto.getId() );
        tarea.setTitulo( dto.getTitulo() );
        tarea.setDescripcion( dto.getDescripcion() );
        tarea.setFechaCreacion( dto.getFechaCreacion() );
        tarea.setEstado( dto.getEstado() );

        return tarea;
    }

    @Override
    public List<TareaDTO> toListDTO(List<Tarea> tareas) {
        if ( tareas == null ) {
            return null;
        }

        List<TareaDTO> list = new ArrayList<TareaDTO>( tareas.size() );
        for ( Tarea tarea : tareas ) {
            list.add( toDTO( tarea ) );
        }

        return list;
    }

    @Override
    public List<Tarea> toListEntity(List<TareaDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Tarea> list = new ArrayList<Tarea>( dtos.size() );
        for ( TareaDTO tareaDTO : dtos ) {
            list.add( toEntity( tareaDTO ) );
        }

        return list;
    }
}
