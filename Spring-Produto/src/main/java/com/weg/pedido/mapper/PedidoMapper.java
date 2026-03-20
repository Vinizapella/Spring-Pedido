package com.weg.Spring_Produto.mapper;

import com.weg.Spring_Produto.dto.PedidoRequest;
import com.weg.Spring_Produto.dto.PedidoResponse;
import com.weg.Spring_Produto.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public Pedido toEntity(
        PedidoRequest pedidoRequest
    ){
        return new Pedido(
                null,
                pedidoRequest.data_pedido()
        );
    }

    public PedidoResponse toResponse(
            Pedido pedido
    ){
        return new PedidoResponse(
                pedido.getId(),
                pedido.getData_pedido()
        );
    }

}
