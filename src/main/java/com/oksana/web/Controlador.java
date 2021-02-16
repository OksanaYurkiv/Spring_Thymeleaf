package com.oksana.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.oksana.servicio.PersonaService;

import lombok.*;

@Controller
public class Controlador {
	
	//inyeccion de la interfaz de tipo DAO
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/")
	public String inicio (Model model) {
		
		var personas = personaService.listarPersonas();
		model.addAttribute("personas", personas);
		return "inicio";
	}

}
