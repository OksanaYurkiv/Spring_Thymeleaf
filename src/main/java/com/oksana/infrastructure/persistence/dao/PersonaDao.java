package com.oksana.infrastructure.persistence.dao;

import com.oksana.infrastructure.persistence.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository <CustomerEntity, Long> {

	
}
