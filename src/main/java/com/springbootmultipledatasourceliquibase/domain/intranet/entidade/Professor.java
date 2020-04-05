package com.springbootmultipledatasourceliquibase.domain.intranet.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@EqualsAndHashCode
@ToString
@Table(schema = "intra", name = "professor")
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private Long id;

    @Column(name = "ds_nome")
    private String nome;

    @Column(name = "ds_sobrenome")
    private String sobrenome;

    @Column(name = "is_status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    @JsonIgnore
    @ManyToMany()
    @JoinTable(name = "disciplina_professor")
    private List<Disciplina> disciplinas = new ArrayList<>();

}