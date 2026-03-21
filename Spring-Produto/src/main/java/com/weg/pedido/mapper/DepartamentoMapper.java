package com.weg.pedido.mapper;

import com.weg.pedido.dto.request.DepartamentoRequestDto;
import com.weg.pedido.dto.response.DepartamentoResponseDto;
import com.weg.pedido.model.Departamento;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoMapper {

    public Departamento toEntity(
            DepartamentoRequestDto departamentoRequest
    ) {
        return new Departamento(
            departamentoRequest.nome(),
            departamentoRequest.sigla()
        );
    }

    public DepartamentoResponseDto toResponse(
            Departamento departamento
    ) {
        return new DepartamentoResponseDto(
            departamento.getId(),
            departamento.getNome(),
            departamento.getSigla()
        );
    }
}