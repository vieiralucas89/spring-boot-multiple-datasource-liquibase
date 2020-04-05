package com.springbootmultipledatasourceliquibase.rest;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Departamento;
import com.springbootmultipledatasourceliquibase.domain.intranet.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoResource {

    @Autowired
    private DepartamentoService departamentoService;

    @Transactional
    @GetMapping
    public List<Departamento> listarAgendas() {
        return departamentoService.findAll();
    }

    @PostMapping
    public Departamento cadastrar(@RequestBody Departamento departamento) {
        return departamentoService.save(departamento);
    }

}
