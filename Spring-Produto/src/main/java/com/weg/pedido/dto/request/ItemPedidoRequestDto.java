package com.weg.pedido.dto.request;

public record ItemPedidoRequestDto(

        String nomeProduto,
        Integer quantidade,
        Double precoUnitario,
        Integer idPedido

) {
}
