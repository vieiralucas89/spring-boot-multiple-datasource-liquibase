package com.springbootmultipledatasourceliquibase.domain.intranet.repository;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
