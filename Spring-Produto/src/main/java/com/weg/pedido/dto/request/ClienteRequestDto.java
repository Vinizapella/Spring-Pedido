package com.weg.pedido.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequestDto(

        @NotBlank
        String nome,

        @NotBlank
        String email
) {
}
