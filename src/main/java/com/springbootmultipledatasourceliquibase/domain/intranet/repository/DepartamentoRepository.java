package com.springbootmultipledatasourceliquibase.domain.intranet.repository;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
