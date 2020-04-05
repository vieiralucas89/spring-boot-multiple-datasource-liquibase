package com.springbootmultipledatasourceliquibase.domain.intranet.entidade;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(schema = "intra", name = "aluno")
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Long id;

    @Column(name = "ds_nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "status")
    private boolean status;

    @Column(name = "email")
    private String email;

    @Column(name = "nome_pai")
    private String nomePai;

    @Column(name = "nome_mae")
    private String nomeMae;

    @Column(name = "whats")
    private String whats;

    @Column(name = "sexo")
    private Integer sexo;

    @ManyToOne()
    @JoinColumn(name = "id_curso")
    private Curso curso;
}
