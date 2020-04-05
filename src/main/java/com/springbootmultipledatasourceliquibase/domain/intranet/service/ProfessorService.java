package com.springbootmultipledatasourceliquibase.domain.intranet.service;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Professor;
import com.springbootmultipledatasourceliquibase.domain.intranet.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Optional<Professor> findById(Long id) {
        return professorRepository.findById(id);
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }
}