package com.springbootmultipledatasourceliquibase.rest;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Carro;
import com.springbootmultipledatasourceliquibase.domain.intranet.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroResource {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<Carro> listarAgendas() {
        return carroService.findAll();
    }

    @PostMapping
    public Carro cadastrar(@RequestBody Carro carro) {
        return carroService.save(carro);
    }

}
