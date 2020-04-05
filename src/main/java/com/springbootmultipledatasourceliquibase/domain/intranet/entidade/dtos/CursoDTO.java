package com.springbootmultipledatasourceliquibase.domain.intranet.entidade.dtos;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Departamento;
import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO implements DTOEntity {

    private String nome;
    private Departamento departamento;
    private List<Turma> turmas = new ArrayList<>();

/*    public CursoDTO(List<DisciplinaDTO> disciplinas) {
        this.disciplinas = ObjectMapperUtils.mapAll(disciplinas, DisciplinaDTO.class);
    }*/
}
