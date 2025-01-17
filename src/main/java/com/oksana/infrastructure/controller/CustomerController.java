package com.oksana.infrastructure.controller;


import com.oksana.application.service.CustomerService;
import com.oksana.domain.Customer;
import com.oksana.infrastructure.persistence.CustomerEntity;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * CustomerController
 *
 * @author Oksana Yurkiv
 */
@RequiredArgsConstructor
@Controller
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) { //añadiendo @AuthenticationPrincipal recuperamos el usuario que hizo login

        var personas = customerService.listarPersonas();
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
    public String agregar(CustomerEntity customerEntity) {
        return "modificar1";

    }

    @PostMapping("/guardar")
    public String guardar(@Valid Customer customer, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar1";
        }
        customerService.guardar(customer);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(CustomerEntity customer, Model model) {
        //estas dos lineas sirven para que los campos se rellenen con los datos de idPersona
        customer = customerService.encontrarPersona(customer);
        model.addAttribute("persona", customer);
        return "modificar1";
    }

    @GetMapping("/eliminar")
    public String eliminar(CustomerEntity customerEntity) {
        customerService.eliminar(customerEntity);
        return "redirect:/";
    }
}
