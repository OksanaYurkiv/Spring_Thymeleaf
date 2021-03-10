package com.oksana.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oksana.domain.Persona;

public interface PersonaDao extends JpaRepository <Persona, Long> {

	
}
