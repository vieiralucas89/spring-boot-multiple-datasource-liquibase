package com.springbootmultipledatasourceliquibase.domain.intranet.repository;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
