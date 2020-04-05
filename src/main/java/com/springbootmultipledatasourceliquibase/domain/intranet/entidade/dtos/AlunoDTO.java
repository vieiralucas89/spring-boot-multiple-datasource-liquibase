package com.springbootmultipledatasourceliquibase.domain.intranet.entidade.dtos;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Curso;
import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO implements DTOEntity {

    private String nome;
    private String cpf;
    private boolean status;
    private String email;
    private String nomePai;
    private String nomeMae;
    private String whats;
    private Integer sexo;
    private Curso curso;
    private Turma turma;

}
