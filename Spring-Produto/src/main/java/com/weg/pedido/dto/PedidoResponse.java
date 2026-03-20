package com.weg.Spring_Produto.dto;

import java.util.Date;

public record PedidoResponse(
        int id,
        Date data_pedido
) {
}
