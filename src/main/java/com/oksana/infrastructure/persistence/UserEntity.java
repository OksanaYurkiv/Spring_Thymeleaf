package com.oksana.infrastructure.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity //JPA no de Hibernate
@Data
@Table(name="usuario")
public class UserEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;

	
	@OneToMany
	@JoinColumn(name="id_usuario")
	private List<RoleEntity> roleEntities;
}
