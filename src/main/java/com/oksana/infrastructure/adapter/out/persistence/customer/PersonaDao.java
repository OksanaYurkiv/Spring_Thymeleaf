package com.oksana.infrastructure.adapter.out.persistence.customer;

import com.oksana.infrastructure.adapter.out.persistence.customer.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<Persona, Long> {

}
