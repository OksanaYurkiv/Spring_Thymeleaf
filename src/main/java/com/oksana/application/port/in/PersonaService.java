package com.oksana.application.port.in;

import com.oksana.infrastructure.adapter.out.persistence.customer.entity.Persona;

import java.util.List;

public interface PersonaService {

    // CRUD method
    List<Persona> listarPersonas();

    void guardar(Persona persona);

    void eliminar(Persona persona);

    Persona encontrarPersona(Long idPersona);

    void editar(Persona persona);
}
