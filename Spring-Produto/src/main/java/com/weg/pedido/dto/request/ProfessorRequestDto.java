package com.weg.pedido.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfessorRequestDto (

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String especialidade

){
}
