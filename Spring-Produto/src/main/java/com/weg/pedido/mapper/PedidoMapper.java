package com.weg.pedido.mapper;

import com.weg.pedido.dto.request.PedidoRequestDto;
import com.weg.pedido.dto.response.PedidoResponseDto;
import com.weg.pedido.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public Pedido toEntity(
            PedidoRequestDto pedidoRequestDto
    ){
        return new Pedido(
                pedidoRequestDto.numeroPedido(),
                pedidoRequestDto.valor(),
                pedidoRequestDto.descricao()
        );
    }

    public PedidoResponseDto toResponse(
            Pedido pedido
    ){
        return new PedidoResponseDto(
                pedido.getId(),
                pedido.getNumeroPedido(),
                pedido.getValor(),
                pedido.getDescricao(),
                pedido.getCliente().getId()
        );

    }

}