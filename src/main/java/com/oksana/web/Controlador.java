package com.oksana.web;


import com.oksana.domain.Persona;
import com.oksana.servicio.PdfService;
import com.oksana.servicio.PersonaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Los GET son para botones, para acceder al formulario.
 * Los POST  por ejemplo:
 * - son acciones de botones del formulario,
 * - los que hacen cambios en la base de datos.
 *
 * @author Oksana Yurkiv
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class Controlador {

    // inyeccion
    private final PersonaService personaService;

    private final PdfService pdfService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) { //añadiendo @AuthenticationPrincipal recuperamos el usuario que hizo login

        var personas = personaService.listarPersonas();
        log.info("usuario que hizo login:" + user);
        model.addAttribute("personas", personas);
        var saldoTotal = 0D;
        for (var p : personas) {
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        return "inicio.html";
    }

    @GetMapping("/save")
    public String add(Model model) {
        model.addAttribute("persona", new Persona());
        return "save_client.html";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("persona") @Valid Persona persona, Errors errores) {
        if (errores.hasErrors()) {
            return "save_client.html";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String updateById(@ModelAttribute("persona") Persona persona, Model model) {

        //estas dos lineas sirven para que los campos se rellenen con los datos de idPersona
        Persona personaExist = personaService.encontrarPersona(persona.getIdPersona());
        model.addAttribute("persona", personaExist);

        return "update_client.html"; // Renderiza el formulario de edición
    }

    @PostMapping("/editar/{idPersona}")
    public String update(@ModelAttribute("persona") Persona persona) {
        personaService.editar(persona); // Actualiza la entidad
        return "redirect:/"; // Redirige a la lista de personas
    }

    @GetMapping("/export/pdf")
    public String exportPdf(HttpServletResponse response) {

        pdfService.exportPdf(response);
        return "redirect:/"; // Redirige a la lista de personas
    }

    @GetMapping("/eliminar")
    public String delete(Persona persona) {
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
