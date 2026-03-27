package com.weg.pedido.dto.response;

public record ProdutoResponseDto(

        Integer id,

        String nome,

        Double preco,

        String nomeCategoria

) {
}
