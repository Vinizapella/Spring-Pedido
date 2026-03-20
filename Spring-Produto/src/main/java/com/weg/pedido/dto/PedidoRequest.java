package com.weg.Spring_Produto.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.util.Date;

public record PedidoRequest (

       @NotNull(message = "A data não pode ser deixada em branco")
       @Past(message = "A data deve ser um pedido no passado")
       Date data_pedido
){
}
