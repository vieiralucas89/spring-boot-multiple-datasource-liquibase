package com.springbootmultipledatasourceliquibase.rest;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Professor;
import com.springbootmultipledatasourceliquibase.domain.intranet.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> listar() {
        return professorService.findAll();
    }

    @PostMapping
    public Professor cadastrar(@RequestBody Professor professor) {
        return professorService.save(professor);
    }

}
