package com.springbootmultipledatasourceliquibase.domain.intranet.entidade;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Table(schema = "intra", name = "intra_departamento")
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long id;

    @Column(name = "ds_nome")
    private String nome;

/*    @OneToMany(mappedBy = "departamento")
    private Set<Curso> cursos = new HashSet<>();*/

}