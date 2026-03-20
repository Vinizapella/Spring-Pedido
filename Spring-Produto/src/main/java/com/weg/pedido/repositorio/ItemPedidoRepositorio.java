package com.weg.pedido.repositorio;

import com.weg.pedido.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, Integer > {
}
