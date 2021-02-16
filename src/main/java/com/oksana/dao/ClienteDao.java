package com.oksana.dao;

import org.springframework.data.repository.CrudRepository;
import com.oksana.domain.Cliente;

public interface ClienteDao extends CrudRepository <Cliente, Long> {

	
}
