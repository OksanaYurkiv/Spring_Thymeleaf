package com.oksana.application.service;

import com.oksana.infrastructure.persistence.dao.PersonaDao;
import com.oksana.infrastructure.persistence.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Customer service
 *
 * @author Oksana Yurkiv
 */
@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<CustomerEntity> listarPersonas() {
        return (List<CustomerEntity>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(CustomerEntity customerEntity) {
        personaDao.save(customerEntity);
    }

    @Override
    @Transactional
    public void eliminar(CustomerEntity customerEntity) {
        personaDao.delete(customerEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerEntity encontrarPersona(CustomerEntity customerEntity) {
        return personaDao.findById(customerEntity.getIdPersona()).orElse(null);
    }

}
