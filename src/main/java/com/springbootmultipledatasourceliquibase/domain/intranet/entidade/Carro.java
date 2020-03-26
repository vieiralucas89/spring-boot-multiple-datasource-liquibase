package com.springbootmultipledatasourceliquibase.domain.intranet.entidade;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@EqualsAndHashCode
@ToString
@Table(schema = "intra", name = "carro")
public class Carro implements Serializable {

    @Id
    @Column(name = "id_carro")
    private Long id;

    @Column(name = "ds_nome")
    private String nome;
}