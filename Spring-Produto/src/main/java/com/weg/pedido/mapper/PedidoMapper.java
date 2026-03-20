package com.weg.pedido.mapper;

import com.weg.pedido.dto.request.PedidoRequestDto;
import com.weg.pedido.dto.response.PedidoResponseDto;
import com.weg.pedido.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public Pedido toEntity(
        PedidoRequestDto pedidoRequest
    ){
        return new Pedido(
                pedidoRequest.data_pedido()
        );
    }

    public PedidoResponseDto toResponse(
            Pedido pedido
    ){
        return new PedidoResponseDto(
                pedido.getId(),
                pedido.getData_pedido()
        );
    }

}
