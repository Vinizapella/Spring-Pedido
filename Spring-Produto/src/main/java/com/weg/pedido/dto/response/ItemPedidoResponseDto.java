package com.weg.pedido.dto.response;

public record ItemPedidoResponseDto(

        Integer id,
        String nomeProduto,
        Integer quantidade,
        Double precoUnitario,
        Integer idPedido

) {

}
