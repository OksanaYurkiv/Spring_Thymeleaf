package com.oksana.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oksana.domain.Persona;
import com.oksana.servicio.PersonaService;

import lombok.var;

@Controller
public class Controlador {

	// inyeccion de la interfaz de tipo DAO
	@Autowired
	private PersonaService personaService;

	@GetMapping("/")
	public String inicio(Model model) {

		var personas = personaService.listarPersonas();
		model.addAttribute("personas", personas);
		return "inicio";
	}

	@GetMapping("/agregar")
	public String agregar(Persona persona) {
		return "modificar1";

	}

	@PostMapping("/guardar")
	public String guardar(Persona persona) {
		personaService.guardar(persona);
		return "redirect:/";
	}

	@GetMapping("/editar/{idPersona}")
	public String editar(Persona persona, Model model) {
		//estas dos lineas sirven para que los campos se rellenen con los datos de idPersona
     persona = personaService.encontrarPersona(persona);
     model.addAttribute("persona", persona);
		return "modificar1";
	}
}
