package com.oksana;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.*;
import lombok.extern.slf4j.Slf4j;





@Controller
@Slf4j
public class Controlador {
	
	
	@Value ("$ {index.saludo}")
	private String saludo;
	
	@GetMapping("/")
	public String inicio (Model model) {
		
		
	
		String nombre= "Enrique";
		
		var persona= new Persona();
		persona.setNombre("Juan");
		persona.setApellido("Perez");
		persona.setEmail("dfdfg2sdfñ.es");
		persona.setTelefono("49568875");
		
		
		var persona2= new Persona();
		persona2.setNombre("Karla");
		persona2.setApellido("Gomez");
		persona2.setEmail("zcszvdb@.com");
		persona2.setTelefono("425386636");
		
		
		//List<Persona> personas = new ArrayList();
		//personas.add(persona);
		//personas.add(persona2);
		
		var personas = Arrays.asList(persona, persona2);
	
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("saludo", saludo);
		
		model.addAttribute("persona", persona);
		model.addAttribute("personas", personas);
		
		
		return "inicio";
	}

}
