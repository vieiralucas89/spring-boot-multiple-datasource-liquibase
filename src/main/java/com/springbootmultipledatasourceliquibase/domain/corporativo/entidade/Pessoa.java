package com.springbootmultipledatasourceliquibase.domain.corporativo.entidade;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@EqualsAndHashCode
@ToString
@Entity
@Table(schema = "corp", name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @Column(name = "id_pessoa")
    private Long id;

    @Column(name = "ds_nome")
    private String nome;
}
