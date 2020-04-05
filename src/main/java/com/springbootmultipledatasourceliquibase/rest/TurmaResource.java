package com.springbootmultipledatasourceliquibase.rest;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Turma;
import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.dtos.TurmaDTO;
import com.springbootmultipledatasourceliquibase.domain.intranet.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaResource {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public List<TurmaDTO> listarAll() {
        return turmaService.findAll();
    }

    @PostMapping
    public Turma cadastrar(@RequestBody Turma turma) {
        return turmaService.save(turma);
    }

}
