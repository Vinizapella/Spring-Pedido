package com.weg.pedido.dto.response;

public record FuncionarioResponseDto(
        Long id,
        String nome,
        String cargo,
        Double salario,
        Long departamentoId,
        String departamentoNome
) {

}