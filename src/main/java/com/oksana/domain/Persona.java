package com.oksana.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
@Entity
@Table (name ="cliente")
public class Persona implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;
	
	@NotEmpty
	private	String nombre;
	
	@NotEmpty // NotEmpty para cadenas
	private	String apellido;
	
	@NotEmpty
	@Email
	private	String email;
	
	private	String telefono;
	
	@NotNull
	private Double saldo;


}
