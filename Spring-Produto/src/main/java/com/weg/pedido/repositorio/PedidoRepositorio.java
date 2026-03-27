package com.weg.pedido.repositorio;

import com.weg.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);
    Pedido findByIdAndDescricao(String descricao, Long id);
}
