package com.springbootmultipledatasourceliquibase.domain.intranet.repository;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
