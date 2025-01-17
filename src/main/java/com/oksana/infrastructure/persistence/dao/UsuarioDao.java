package com.oksana.infrastructure.persistence.dao;

import com.oksana.infrastructure.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);

}
