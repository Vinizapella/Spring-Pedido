package com.weg.pedido.dto.response;

import java.util.Date;

public record PedidoResponseDto(
        Integer id,
        Date data_pedido
) {
}
