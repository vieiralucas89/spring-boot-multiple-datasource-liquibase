package com.springbootmultipledatasourceliquibase.domain.corporativo.service;

import com.springbootmultipledatasourceliquibase.domain.corporativo.entidade.Pessoa;
import com.springbootmultipledatasourceliquibase.domain.corporativo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }


}