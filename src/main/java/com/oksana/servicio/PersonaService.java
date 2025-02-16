package com.oksana.servicio;

import com.oksana.domain.Persona;

import java.util.List;

public interface PersonaService {

    // CRUD method
    List<Persona> listarPersonas();

    void guardar(Persona persona);

    void eliminar(Persona persona);

    Persona encontrarPersona(Long idPersona);

    void editar(Persona persona);
}
