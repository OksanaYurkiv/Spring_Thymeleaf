package com.oksana.dao;

import org.springframework.data.repository.CrudRepository;
import com.oksana.domain.Persona;

public interface PersonaDao extends CrudRepository <Persona, Long> {

	
}
