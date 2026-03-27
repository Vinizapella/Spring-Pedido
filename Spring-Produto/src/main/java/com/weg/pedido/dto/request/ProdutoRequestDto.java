package com.weg.pedido.dto.request;

import jakarta.validation.constraints.*;

public record ProdutoRequestDto(

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String nome,

        @NotNull(message = "O preço é obrigatório")
        @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero")
        Double preco,

        @NotNull(message = "A categoria é obrigatória")
        @Positive(message = "O ID da categoria deve ser positivo")
        Integer categoriaId

) {
}
