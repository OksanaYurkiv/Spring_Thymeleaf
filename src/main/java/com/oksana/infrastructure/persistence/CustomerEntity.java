package com.oksana.infrastructure.persistence;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Customer entity
 *
 * @author Oksana Yurkiv
 */
@Data
@Entity
@Table(name = "cliente")
public class CustomerEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * idPersona
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    /**
     * idPersona
     */
    @NotEmpty
    private String nombre;
    /**
     * idPersona
     */
    @NotEmpty
    private String apellido;
    /**
     * idPersona
     */
    @NotEmpty
    @Email
    private String email;
    /**
     * idPersona
     */
    private String telefono;
    /**
     * idPersona
     */
    @NotNull
    private Double saldo;


}
