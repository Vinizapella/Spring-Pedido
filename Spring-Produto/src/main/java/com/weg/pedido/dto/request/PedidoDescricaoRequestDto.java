package com.weg.pedido.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PedidoDescricaoRequestDto(

        @NotBlank
        String descricao

) {
}
