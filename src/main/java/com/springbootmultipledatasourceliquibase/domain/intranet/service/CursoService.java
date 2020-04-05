package com.springbootmultipledatasourceliquibase.domain.intranet.service;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Curso;
import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.dtos.CursoDTO;
import com.springbootmultipledatasourceliquibase.domain.intranet.repository.CursoRepository;
import com.springbootmultipledatasourceliquibase.domain.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoDTO> findAll() {

        List<Curso> cursos = cursoRepository.findAllCursos();
        /*List<CursoDTO> cursos = cursoRepository.findAllCursoDTO();*/
        return new ObjectMapperUtils().mapAll(cursos, CursoDTO.class);
    }

    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }
}