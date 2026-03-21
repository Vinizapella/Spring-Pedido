package com.weg.pedido.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DepartamentoRequestDto(
        @NotBlank(message = "O nome do departamento é obrigatório.")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
        String nome,

        @NotBlank(message = "A sigla é obrigatória.")
        @Size(min = 2, max = 10, message = "A sigla deve ter entre 2 e 10 caracteres.")
        String sigla
) {
}
