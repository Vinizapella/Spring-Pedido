package com.weg.pedido.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoRequestDto (

        @NotBlank
        String numeroPedido,

        @NotNull
        Double valor,

        @NotNull
        String descricao,

        @NotNull
        Long clienteId

){
}
