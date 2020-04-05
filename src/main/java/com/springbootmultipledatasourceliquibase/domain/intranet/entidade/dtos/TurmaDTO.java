package com.springbootmultipledatasourceliquibase.domain.intranet.entidade.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaDTO implements DTOEntity {

    private String descricao;
    private String periodo;
    private Integer nr_alunos;
    private LocalDate dt_inicio;
    private LocalDate dt_fim;


}
