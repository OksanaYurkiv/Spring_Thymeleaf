package com.oksana.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name ="cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	private	String nombre;
	private	String apellido;
	private	String email;
	private	String telefono;
    private String saldo;

}
