package com.springbootmultipledatasourceliquibase.rest;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.dtos.AlunoDTO;
import com.springbootmultipledatasourceliquibase.domain.intranet.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<AlunoDTO> listarAlunos() {
        return alunoService.findAll();
    }


}
