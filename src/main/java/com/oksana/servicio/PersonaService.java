package com.oksana.servicio;

import java.util.List;

import com.oksana.domain.Persona;

public interface PersonaService {
	
	//añadimos metodos CRUD
	public List<Persona> listarPersonas();
	
	public void guardar (Persona persona);
	
	public void eliminar (Persona persona);
	
	public Persona encontrarPersona (Persona persona);
	
}
