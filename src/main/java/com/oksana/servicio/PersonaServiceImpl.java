package com.oksana.servicio;

import com.oksana.dao.PersonaDao;
import com.oksana.domain.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Long idPersona) {
        Persona persona = personaDao.findById(idPersona).orElse(null);

        if (persona == null) {
            throw new EntityNotFoundException("Persona con ID " + idPersona + " no encontrada.");
        }
        return persona;
    }

    @Override
    @Transactional
    public void editar(Persona persona) {
        if (persona != null && persona.getIdPersona() != null) {
            Persona personaExistente = personaDao.findById(persona.getIdPersona()).orElse(null);
            if (personaExistente != null) {
                personaDao.save(persona); // Actualiza la persona
            } else {
                throw new EntityNotFoundException("Persona con ID " + persona.getIdPersona() + " no encontrada.");
            }
        } else {
            throw new IllegalArgumentException("La persona o su ID no puede ser nula.");
        }
    }

}
