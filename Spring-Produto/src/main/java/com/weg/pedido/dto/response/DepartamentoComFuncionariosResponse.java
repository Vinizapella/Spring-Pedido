package com.weg.pedido.dto.response;

import java.util.List;

public record DepartamentoComFuncionariosResponse(
        Long id,
        String nome,
        String sigla,
        List<FuncionarioResponseDto> funcionarios
) {
}
