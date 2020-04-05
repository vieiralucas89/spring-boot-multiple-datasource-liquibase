package com.springbootmultipledatasourceliquibase.rest;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Curso;
import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.dtos.CursoDTO;
import com.springbootmultipledatasourceliquibase.domain.intranet.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoResource {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoDTO> listarAgendas() {
        return cursoService.findAll();
    }

    @PostMapping
    public Curso cadastrar(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

}
