package com.springbootmultipledatasourceliquibase.domain.intranet.repository;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import static org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

/*    @Query(value = "select new com.springbootmultipledatasourceliquibase.domain.intranet.entidade.dtos.CursoDTO(c.nome, d) " +
            " from Curso c " +
            " join c.departamento d ")
    public List<CursoDTO> findAllCursoDTO();*/

    @Query(value = "select distinct c" +
            " from Curso c " +
            " left join fetch c.departamento d " +
            " left join fetch c.turmas t ")

    @QueryHints(value = @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false"))
    public List<Curso> findAllCursos();

}
