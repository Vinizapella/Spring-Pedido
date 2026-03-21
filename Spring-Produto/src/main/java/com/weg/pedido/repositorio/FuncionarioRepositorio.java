package com.weg.pedido.repositorio;

import com.weg.pedido.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByDepartamentoId(Long departamentoId);

    List<Funcionario> findByNomeContainingIgnoreCase(String nome);

    @Query("""
            SELECT f FROM Funcionario f 
                WHERE 
                (:id IS NULL OR f.id = :id) AND 
                (:nome IS NULL OR LOWER(f.nome) 
                LIKE LOWER(CONCAT('%', :nome, '%')))
        """)

    List<Funcionario> buscarComFiltros(@Param("id") Long id,
                                       @Param("nome") String nome);
}

