package com.springbootmultipledatasourceliquibase.rest;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Disciplina;
import com.springbootmultipledatasourceliquibase.domain.intranet.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public List<Disciplina> listar() {
        return disciplinaService.findAll();
    }

    @PostMapping
    public Disciplina cadastrar(@RequestBody Disciplina disciplina) {
        return disciplinaService.save(disciplina);
    }

}
