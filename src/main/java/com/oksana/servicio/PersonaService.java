package com.oksana.servicio;

import java.util.List;

import com.oksana.domain.Cliente;

public interface PersonaService {
	
	//añadimos metodos CRUD
	public List<Cliente> listarPersonas();
	
	public void guardar (Cliente persona);
	
	public void eliminar (Cliente persona);
	
	public Cliente encontrarPersona (Cliente persona);
	
}
