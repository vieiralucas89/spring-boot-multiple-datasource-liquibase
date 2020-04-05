package com.springbootmultipledatasourceliquibase.domain.intranet.service;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Turma;
import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.dtos.TurmaDTO;
import com.springbootmultipledatasourceliquibase.domain.intranet.repository.TurmaRepository;
import com.springbootmultipledatasourceliquibase.domain.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<TurmaDTO> findAll() {
        List<TurmaDTO> turmaDTOS = new ArrayList<>();
        turmaRepository.findAll().stream().forEach(turma -> turmaDTOS.add(
                (TurmaDTO) new DtoUtils().convertToDto(turma, new TurmaDTO())
        ));
        return turmaDTOS;
    }

    public Optional<Turma> findById(Long id) {
        return turmaRepository.findById(id);
    }

    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }
}