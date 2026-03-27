package com.weg.pedido.repositorio;

import com.weg.pedido.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

    List<Produto> findByNome(String nome);

    Optional<Produto> findByIdAndNome(Integer id, String nome);

    List<Produto> findByCategoriaId(Integer categoriaId);

    List<Produto> findByCategoriaNome(String nomeCategoria);

}
