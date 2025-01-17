package com.oksana.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Customer domain
 *
 * @author Oksana Yurkiv
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    private Long idPersona;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email
    private String email;
    private String telefono;
    @NotNull
    private Double saldo;


}
