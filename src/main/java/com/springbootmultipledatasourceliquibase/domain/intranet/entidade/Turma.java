package com.springbootmultipledatasourceliquibase.domain.intranet.entidade;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(schema = "intra", name = "turma")
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turma")
    private Long id;

    @Column(name = "ds_turma")
    private String descricao;

    @Column(name = "periodo")
    private String periodo;

    @Column(name = "nr_alunos")
    private Integer nr_alunos;

    @Column(name = "dt_inicio")
    private LocalDate dt_inicio;

    @Column(name = "dt_fim")
    private LocalDate dt_fim;

}