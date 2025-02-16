package com.oksana.infrastructure.adapter.out.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
	Usuario findByUsername(String username);

}
