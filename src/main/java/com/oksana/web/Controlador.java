package com.oksana.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oksana.domain.Cliente;
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
	@GetMapping("/agregar")
   public String agregar (Cliente persona) {
		return "modificar1";
		
	}
	@PostMapping ("/guardar")
	public String guardar(Cliente persona) {
			personaService.guardar (persona);
		return "redirect:/";
	}
}
