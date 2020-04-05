package com.springbootmultipledatasourceliquibase.domain.intranet.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Table(schema = "intra", name = "disciplina")
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina")
    private Long id;

    @Column(name = "ds_nome")
    private String nome;

    @Column(name = "ds_curricular")
    private String descricao;

    @Column(name = "nr_alunos")
    private Integer nrAlunos;

    @Column(name = "nr_carga_horaria")
    private Integer cargaHoraria;

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "id_disciplina_pai")
    private Disciplina disciplinaPai;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

}