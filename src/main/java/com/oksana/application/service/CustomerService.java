package com.oksana.application.service;

import com.oksana.domain.Customer;
import com.oksana.infrastructure.persistence.CustomerEntity;

import java.util.List;

/**
 * Customer interface
 *
 * @author Oksana Yurkiv
 */
public interface CustomerService {

    List<CustomerEntity> listarPersonas();

    void guardar(Customer customer);

    void eliminar(CustomerEntity customerEntity);

    CustomerEntity encontrarPersona(CustomerEntity customerEntity);

}
