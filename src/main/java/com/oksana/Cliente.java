package com.oksana;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name ="cliente")
public class Cliente {
	
	private	String nombre;
	private	String apellido;
	private	String email;
	private	String telefono;
    private String saldo;

}
