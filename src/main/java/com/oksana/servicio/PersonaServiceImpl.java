package com.oksana.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oksana.dao.ClienteDao;
import com.oksana.domain.Cliente;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private ClienteDao personaDao;

	@Override
	@Transactional (readOnly = true)
	public List<Cliente> listarPersonas() {
		return (List<Cliente>) personaDao.findAll();
	}

	@Override
	@Transactional 
	public void guardar(Cliente persona) {
        personaDao.save(persona);
	}

	@Override
	@Transactional
	public void eliminar(Cliente persona) {
personaDao.delete(persona);
	}

	@Override
	@Transactional (readOnly = true)
	public Cliente encontrarPersona(Cliente persona) {
       return personaDao.findById(persona.getIdCliente()).orElse (null);
	}

}
