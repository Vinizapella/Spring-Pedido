package com.weg.pedido.repositorio;

import com.weg.pedido.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepositorio extends JpaRepository<Professor, Integer> {
}
