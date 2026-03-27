package com.weg.pedido.mapper;

import com.weg.pedido.dto.request.ClienteRequestDto;
import com.weg.pedido.dto.response.ClienteResponseDto;
import com.weg.pedido.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(
            ClienteRequestDto clienteRequestDto
    ) {
        return new Cliente(
                clienteRequestDto.nome(),
                clienteRequestDto.email()
        );
    }

    public ClienteResponseDto toResponde(
            Cliente cliente
    ){
        return new ClienteResponseDto(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail()
        );
    }

}
