package com.springbootmultipledatasourceliquibase.domain.intranet.entidade.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaDTO implements DTOEntity {

    private String nome;
    private String descricao;
    private Integer nrAlunos;
    private Integer cargaHoraria;
/*    private Disciplina disciplinaPai;
    private Departamento departamento;*/

}
