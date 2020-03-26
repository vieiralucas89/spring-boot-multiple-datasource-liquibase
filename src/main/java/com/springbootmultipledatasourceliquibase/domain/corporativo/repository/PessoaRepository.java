package com.springbootmultipledatasourceliquibase.domain.corporativo.repository;

import com.springbootmultipledatasourceliquibase.domain.corporativo.entidade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
