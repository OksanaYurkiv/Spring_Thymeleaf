package com.oksana.web;


import com.oksana.domain.Persona;
import com.oksana.servicio.PersonaService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @author Oksana Yurkiv
 */
@Controller
public class Controlador {

    // inyeccion de la interfaz de tipo DAO
    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) { //añadiendo @AuthenticationPrincipal recuperamos el usuario que hizo login

        var personas = personaService.listarPersonas();
        //log.info("usuario que hizo login:" + user);  //mandar el mensaje a la consola OJO! importar la clase para que funcione
        model.addAttribute("personas", personas);
        var saldoTotal = 0D;
        for (var p : personas) {
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        return "inicio";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar1";

    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar1";
        }
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

    @GetMapping("/eliminar")
    public String eliminar(Persona persona) {
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
