package com.oksana.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oksana.domain.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
	Usuario findByUsername(String username);

}
