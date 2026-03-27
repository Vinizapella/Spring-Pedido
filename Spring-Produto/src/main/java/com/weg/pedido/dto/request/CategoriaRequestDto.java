package com.weg.pedido.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequestDto(

        @NotBlank(message = "O nome é obrigatório")
        String nome

) {
}
