package com.springbootmultipledatasourceliquibase.domain.intranet.service;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Aluno;
import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.dtos.AlunoDTO;
import com.springbootmultipledatasourceliquibase.domain.intranet.repository.AlunoRepository;
import com.springbootmultipledatasourceliquibase.domain.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoDTO> findAll() {

        List<Aluno> alunos = alunoRepository.findAll();
        return new ObjectMapperUtils().mapAll(alunos, AlunoDTO.class);
    }

}