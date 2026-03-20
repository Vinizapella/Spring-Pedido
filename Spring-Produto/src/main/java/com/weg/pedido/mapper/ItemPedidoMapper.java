package com.weg.pedido.mapper;

import com.weg.pedido.dto.request.ItemPedidoRequestDto;
import com.weg.pedido.dto.response.ItemPedidoResponseDto;
import com.weg.pedido.model.ItemPedido;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoMapper {

    public ItemPedido toEntity(
            ItemPedidoRequestDto itemPedidoRequestDto
    ){
        return new ItemPedido(
                itemPedidoRequestDto.nomeProduto(),
                itemPedidoRequestDto.quantidade(),
                itemPedidoRequestDto.precoUnitario()
        );
    }

    public ItemPedidoResponseDto toResponse(
            ItemPedido itemPedido
    ){
        return new ItemPedidoResponseDto(
                itemPedido.getId(),
                itemPedido.getNomeProduto(),
                itemPedido.getQuantidade(),
                itemPedido.getPrecoUnitario(),
                itemPedido.getPedido().getId()
        );
    }

}
