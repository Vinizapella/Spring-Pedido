package com.weg.pedido.dto.response;

public record PedidoResponseDto (

        Long id,

        String numeroPedido,

        Double valor,

        String descricao,

        Long clienteId

){
}
