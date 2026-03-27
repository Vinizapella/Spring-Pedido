package com.weg.pedido.repositorio;

import com.weg.pedido.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Integer> {

    List<Curso> findByProfessorNome(String professorNome);

    List<Curso> findByProfessorId(Integer professorId);

    Optional<Curso> findByIdAndNome(Integer id, String nome);

}
