package com.oksana.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.oksana.dao.ClienteDao;
import lombok.*;

@Controller
public class Controlador {
	
	//inyeccion de la interfaz de tipo DAO
	@Autowired
	private ClienteDao clienteDao;
	
	@GetMapping("/")
	public String inicio (Model model) {
		
		var personas = clienteDao.findAll();
		model.addAttribute("personas", personas);
		return "inicio";
	}

}
