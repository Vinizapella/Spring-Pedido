package com.weg.pedido.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record FuncionarioRequestDto(
        @NotBlank(message = "O nome é obrigatório.")
        @Size(min = 3, max = 150, message = "O nome deve ter entre 3 e 150 caracteres.")
        String nome,

        @NotBlank(message = "O cargo é obrigatório.")
        String cargo,

        @NotNull(message = "O salário deve ser informado.")
        @Positive(message = "O salário deve ser um valor maior que zero.")
        Double salario,

        @NotNull(message = "O ID do departamento é obrigatório.")
        Long departamentoId
) {
}
