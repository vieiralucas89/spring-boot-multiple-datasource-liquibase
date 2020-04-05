package com.springbootmultipledatasourceliquibase.domain.intranet.service;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Departamento;
import com.springbootmultipledatasourceliquibase.domain.intranet.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;


    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> findById(Long id) {
        return departamentoRepository.findById(id);
    }

    public Departamento save(Departamento departamento) {

        return departamentoRepository.save(departamento);
    }
}